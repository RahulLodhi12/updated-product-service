package com.tcs.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.product.entity.Products;
import com.tcs.product.entity.ProductsImages;
import com.tcs.product.service.ProductService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
//@RequestMapping("/admin/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/products") //public url
	public List<Products> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{name}") //public url
	public List<Products> getAllProductByName(@PathVariable String name){
		return productService.getAllProductsByName(name);
	}
	
	@GetMapping("/products/category/{category}") //public url
	public List<Products> getProductByCategories(@PathVariable String category) {
		return productService.getProductByCategories(category);
	}
	
	@GetMapping("/product/{id}") //public url
	public Optional<Products> getProductById(@PathVariable Integer id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/productImage/{id}")
	public List<ProductsImages> getProductImageById(@PathVariable Integer id){
		return productService.getProductImageById(id);
	}
	
	@PostMapping("/admin/addProduct")
	public Products addNewProducts(@RequestBody Products product) {
		return productService.addNewProduct(product);
	}
	
	@DeleteMapping("/admin/products/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		return productService.deleteProduct(id);
	}
	
	@PutMapping("/admin/products/{id}")
	public String updateProduct(@PathVariable Integer id, @RequestBody Products product, @RequestParam String imageUrl) {
		return productService.updateProduct(id, product, imageUrl);
	}
	
	@PostMapping("/admin/products/{id}/image")
	public void uploadProductImages(@PathVariable Integer id, @RequestParam String url) {
		productService.uploadProductImages(id,url);
	}
	
	
	
}
