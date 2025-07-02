package com.tcs.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tcs.product.entity.Products;
import com.tcs.product.entity.ProductsImages;
import com.tcs.product.exception.NoProductsFoundException;
import com.tcs.product.repository.ProductRepository;
import com.tcs.product.repository.ProductsImagesRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepoitory;
	
	@Autowired
	ProductsImagesRepository productImageRepo;
	
	public Products addNewProduct(Products product) {
		return productRepoitory.save(product);
	}
	
	public String updateProduct(Integer id, Products product, String imageUrl) {
		product.setProductId(id);
		List<ProductsImages> piList = productImageRepo.findByProductsProductId(product.getProductId());
		
		piList.get(0).setProduct(product);
		piList.get(0).setUrl(imageUrl);
		
		product.setProductImagesList(null);
		if(productRepoitory.findById(id).isPresent()) {	
			productRepoitory.save(product);
			productImageRepo.saveAll(piList);
			return "Update Sucess";
		}
		else {	
			throw new NoProductsFoundException();
		}
	}
	
	public Page<Products> getAllProducts(int page, int size) {
		return productRepoitory.findAll(PageRequest.of(page,size));
	}
	
	public List<Products> getAllProductsByName(String name){
		if(productRepoitory.findByProductNameContainingIgnoreCase(name).isEmpty())
			throw new NoProductsFoundException();
		else return productRepoitory.findByProductNameContainingIgnoreCase(name);
	}
	
	public String deleteProduct(Integer id) {
		if(productRepoitory.findById(id).isPresent()) {
			productRepoitory.deleteById(id);
			return "The Item with ID: "+id+" is deleted!!";
		}else throw new NoProductsFoundException();
	}

	public List<Products> getProductByCategories(String category) {
		return productRepoitory.findByCategoryContainingIgnoreCase(category);
	}

	public Optional<Products> getProductById(Integer id) {
		Optional<Products> product = productRepoitory.findById(id);
		if(product.isEmpty()) {
			throw new NoProductsFoundException();
		}
		
		return product;
	}

	public void uploadProductImages(Integer id, String url) {
		Optional<Products> product = productRepoitory.findById(id);
		if(product.isEmpty()) {
			System.out.println("Not uploaded..1");
			return;
		}
			
		List<ProductsImages> productImageList = productImageRepo.findByProductsProductId(product.get().getProductId());
		if(productImageList.isEmpty()) { //not present in ProductImage
			ProductsImages newProductImage = new ProductsImages(); //new Object
			newProductImage.setProduct(product.get());
			newProductImage.setUrl(url);
			
			productImageRepo.save(newProductImage);
		}
		else {
			ProductsImages newProductImage = new ProductsImages(); //new Object
			newProductImage.setProduct(product.get());
			newProductImage.setUrl(url);
			
			productImageList.add(newProductImage);
			
			productImageRepo.save(newProductImage);
		}
	}
	
	public List<ProductsImages> getProductImageById(Integer id) {
		Optional<Products> product = productRepoitory.findById(id);
		if(product.isEmpty()) {
			throw new NoProductsFoundException();
		}
		
		List<ProductsImages> productImages = productImageRepo.findByProductsProductId(product.get().getProductId());
		
		return productImages;
	}
}
