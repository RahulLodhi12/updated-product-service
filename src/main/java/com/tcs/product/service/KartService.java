package com.tcs.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.product.entity.Kart;
import com.tcs.product.entity.Products;
import com.tcs.product.repository.KartRepository;
import com.tcs.product.repository.ProductRepository;

@Service
public class KartService {
	@Autowired
	KartRepository kartRepo;

	@Autowired
	ProductRepository prodRepo;
	
	
	public boolean addProductToKart(@RequestParam Integer cid, @RequestParam Integer pid) { //add to cart + update the quantity
		Optional<Products> product = prodRepo.findById(pid); 
		if(product.isPresent()) {//product is available
			Optional<Kart> exist = kartRepo.findByCustomerIdAndProductId(cid, pid); //combo
			if (exist.isPresent()) { //combo exist -> update the Qty
				int currentQuantity = exist.get().getQuantity();
				System.out.println(currentQuantity);
				exist.get().setQuantity(currentQuantity + 1);
				kartRepo.save(exist.get());
				return true;
			} else { // combo not exists -> add product to Kart
				Kart kart = new Kart(cid, pid); //qty = 1 
				kartRepo.save(kart);
				return true;
			}
		}
		else {
			return false;
		}
	}
}
