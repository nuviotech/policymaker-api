package com.sellerPolicy.Api.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@Column(name="Product_ref_id")
	String product_ref_id;
	
	@Column(name="Category_id")
	String categoryId;
	
	@Column(name="Title")
	String title;
	
	@Column(name="Createt_Date_Time")
	Date createdDateTime;
	
	@Column(name="HSN_Code")
	String hsnNo;
	
	@Column(name="Seller_Id")
	String sellerId;
	
	@Column(name="Description")
	String description;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	private List<ProductReviews> productReviews = new ArrayList<>();

	public String getProduct_ref_id() {
		return product_ref_id;
	}

	public void setProduct_ref_id(String product_ref_id) {
		this.product_ref_id = product_ref_id;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getHsnNo() {
		return hsnNo;
	}

	public void setHsnNo(String hsnNo) {
		this.hsnNo = hsnNo;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductReviews> getProductReviews() {
		return productReviews;
	}

	public void setProductReviews(List<ProductReviews> productReviews) {
		this.productReviews = productReviews;
	}

	
}
