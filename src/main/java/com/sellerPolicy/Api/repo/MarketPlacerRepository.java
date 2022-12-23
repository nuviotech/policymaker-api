package com.sellerPolicy.Api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellerPolicy.Api.entity.MarketPlace;


public interface MarketPlacerRepository extends JpaRepository<MarketPlace, Integer> {
	public MarketPlace findByEmailAddrAndPassword(String emailId,String password);
	public MarketPlace findByEmailAddr(String email);
}
