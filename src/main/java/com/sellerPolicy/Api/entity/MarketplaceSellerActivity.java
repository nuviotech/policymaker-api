package com.sellerPolicy.Api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MarketplaceSellerActivity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	int marketplaceId;
	int sellerId;
	
	String marketplaceAction;
	String sellerAction;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMarketplaceId() {
		return marketplaceId;
	}
	public void setMarketplaceId(int marketplaceId) {
		this.marketplaceId = marketplaceId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getMarketplaceAction() {
		return marketplaceAction;
	}
	public void setMarketplaceAction(String marketplaceAction) {
		this.marketplaceAction = marketplaceAction;
	}
	public String getSellerAction() {
		return sellerAction;
	}
	public void setSellerAction(String sellerAction) {
		this.sellerAction = sellerAction;
	}
	
	
}
