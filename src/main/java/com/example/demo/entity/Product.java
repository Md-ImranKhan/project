package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDet() {
		return productDet;
	}
	public void setProductDet(String productDet) {
		this.productDet = productDet;
	}
	private int productId;
	private String productName;
	private String productDet;
	

}
