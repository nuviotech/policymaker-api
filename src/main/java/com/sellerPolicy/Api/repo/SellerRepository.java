package com.sellerPolicy.Api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellerPolicy.Api.entity.Seller;



public interface SellerRepository extends JpaRepository<Seller, Integer> {
	public Seller findByEmailAddrAndPassword(String emailId,String password);
	public Seller findByEmailAddr(String email);

}
