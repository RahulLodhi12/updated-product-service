package com.tcs.product.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.*;

@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@Column(nullable = false)
	private String productName;
	
	@Column(nullable = false)
	private Integer quantity;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String category;
	
	@Column(nullable = false)
	private Double price;
	
	@Column(nullable = false)
	private Double rating;
	
	@Column(nullable=false)
	private String availabilityStatus;	
	
	@OneToMany(mappedBy="products",cascade=CascadeType.ALL)
	private List<ProductsImages> productImagesList = new ArrayList<>();
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	public String getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	
	public List<ProductsImages> getProductImagesList() {
		return productImagesList;
	}
	public void setProductImagesList(List<ProductsImages> productImagesList) {
		this.productImagesList = productImagesList;
	}
	public Products() {
	
	}
	public Products(Integer productId, String productName, Integer quantity, String description, String category,
			Double price, Double rating, String availabilityStatus, List<ProductsImages> productImagesList) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.description = description;
		this.category = category;
		this.price = price;
		this.rating = rating;
		this.availabilityStatus = availabilityStatus;
		this.productImagesList = productImagesList;
	}
	
	
		
}
