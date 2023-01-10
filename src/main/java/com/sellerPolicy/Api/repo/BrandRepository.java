package com.sellerPolicy.Api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellerPolicy.Api.entity.Brands;

public interface BrandRepository extends JpaRepository<Brands, Integer> {

}
