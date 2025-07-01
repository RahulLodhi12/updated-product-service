package com.tcs.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.product.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer>{
	List<Products> findByProductNameContainingIgnoreCase(String name);

	List<Products> findByCategoryContainingIgnoreCase(String category);

//	List<Products> findAllById(Integer cid);
}
