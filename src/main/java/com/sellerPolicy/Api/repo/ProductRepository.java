package com.sellerPolicy.Api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellerPolicy.Api.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

}
