package com.tcs.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.product.entity.ProductsImages;

public interface ProductsImagesRepository extends JpaRepository<ProductsImages, Integer>{

	List<ProductsImages> findByProductsProductId(Integer productId);

}
