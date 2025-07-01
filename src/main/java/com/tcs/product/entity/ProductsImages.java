package com.tcs.product.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class ProductsImages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productImageId;
	
	private String url;
	
	@ManyToOne
	@JoinColumn(name="product_id") //F.K connects with Products table
	@JsonIgnore
	private Products products;

	
	public ProductsImages() {
		
	}
	
	public ProductsImages(Integer productImageId, String url, Products products) {
		super();
		this.productImageId = productImageId;
		this.url = url;
		this.products = products;
	}

	public Integer getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(Integer productImageId) {
		this.productImageId = productImageId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Products getProduct() {
		return products;
	}

	public void setProduct(Products products) {
		this.products = products;
	}
	
	
}
