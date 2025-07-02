package com.tcs.product.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.tcs.product.entity.Products;
import com.tcs.product.entity.ProductsImages;
import com.tcs.product.exception.NoProductsFoundException;
import com.tcs.product.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	@Mock
	private ProductRepository productRepo;
	
	@InjectMocks
	private ProductService productService;
	
	@Test
	public void getAllProductsByName_Success() throws NoProductsFoundException {
		ProductsImages productImage1 = new ProductsImages();
		productImage1.setProductImageId(101);
		productImage1.setUrl("http://testSite.com/image1.jpg");
		
		ProductsImages productImage2 = new ProductsImages();
		productImage2.setProductImageId(101);
		productImage2.setUrl("http://testSite.com/image2.jpg");
		
		Products product = new Products();
		product.setProductId(11);
		product.setProductName("test product");
		product.setDescription("test product description..");
		product.setCategory("testcase");
		product.setQuantity(450);
		product.setAvailabilityStatus("yes");
		product.setPrice(1200.00);
		product.setRating(4.5);
		
		productImage1.setProduct(product);
		productImage2.setProduct(product);
		
		List<Products> plist = new ArrayList<>();
		plist.add(product);
		
		when(productRepo.findByProductNameContainingIgnoreCase("test product")).thenReturn(plist);
		
		List<Products> oList = productService.getAllProductsByName("test product");
		
		assertEquals("test product", oList.get(0).getProductName());
	}
	
	@Test
	public void getAllProductsByName_Failure() {
		ProductsImages productImage1 = new ProductsImages();
		productImage1.setProductImageId(101);
		productImage1.setUrl("http://testSite.com/image1.jpg");
		
		ProductsImages productImage2 = new ProductsImages();
		productImage2.setProductImageId(101);
		productImage2.setUrl("http://testSite.com/image2.jpg");
		
		Products product = new Products();
		product.setProductId(11);
		product.setProductName("test product");
		product.setDescription("test product description..");
		product.setCategory("testcase");
		product.setQuantity(450);
		product.setAvailabilityStatus("yes");
		product.setPrice(1200.00);
		product.setRating(4.5);
		
		productImage1.setProduct(product);
		productImage2.setProduct(product);
		
		List<Products> plist = new ArrayList<>();
		plist.add(product);
		
		when(productRepo.findByProductNameContainingIgnoreCase("test product")).thenReturn(Collections.emptyList());
		
		NoProductsFoundException exception = assertThrows(NoProductsFoundException.class,()->
			productService.getAllProductsByName("test product")
		);
		
		assertEquals("No product matched the search",exception.getMessage());
	}
	
}











