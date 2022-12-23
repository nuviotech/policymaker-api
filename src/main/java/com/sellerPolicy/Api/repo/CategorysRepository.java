package com.sellerPolicy.Api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellerPolicy.Api.entity.Categorys;


public interface CategorysRepository extends JpaRepository<Categorys, Integer> {
	public Categorys findByCatergoryName(String categoryName);
	
}
