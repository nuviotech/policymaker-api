package com.sellerPolicy.Api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Categorys {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Category_id")
	private int categoryId;
	
	@Column(name="Category_name")
	private String name;
	
	String slug;
	String created_at;
	String updated_at;
	
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST ,mappedBy = "categorysList")
	List<Seller> sellerList=new ArrayList<>();
	
	@ManyToMany(mappedBy = "categorysListM")
	List<MarketPlace> marketplaceList=new ArrayList<>();
	
	public Categorys() {}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCatergoryName() {
		return name;
	}

	public void setCatergoryName(String catergoryName) {
		this.name = catergoryName;
	}
/*
	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
*/

	public List<Seller> getSellerList() {
		return sellerList;
	}

	public void setSellerList(List<Seller> sellerList) {
		this.sellerList = sellerList;
	}

	public List<MarketPlace> getMarketplaceList() {
		return marketplaceList;
	}

	public void setMarketplaceList(List<MarketPlace> marketplaceList) {
		this.marketplaceList = marketplaceList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "{\"categoryId\":" + categoryId + ", \"name\":\"" + name + "\", \"slug\":\"" + slug + "\", \"created_at\":\""
				+ created_at + "\", \"updated_at\":\"" + updated_at + "\"}";
	}
	
	
}
