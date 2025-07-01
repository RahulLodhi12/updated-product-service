package com.tcs.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.product.entity.Kart;
import com.tcs.product.entity.Products;
import com.tcs.product.exception.NoProductsFoundException;
import com.tcs.product.repository.KartRepository;
import com.tcs.product.repository.ProductRepository;
import com.tcs.product.service.KartService;

@RestController
//@RequestMapping("")
public class KartController {

	@Autowired
	KartService kartService;


	@PostMapping("/user/products/addCart") //add to cart + update the quantity
	public boolean addProductToKart(@RequestParam Integer cid, @RequestParam Integer pid) {
		boolean res = kartService.addProductToKart(cid, pid);
		if(res==false) {
			throw new NoProductsFoundException();
		}
		return res;
	}

}
