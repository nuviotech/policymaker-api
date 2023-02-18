package com.sellerPolicy.Api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellerPolicy.Api.entity.Brands;
import com.sellerPolicy.Api.entity.Categorys;
import com.sellerPolicy.Api.repo.BrandRepository;
import com.sellerPolicy.Api.repo.CategorysRepository;

@CrossOrigin(origins = {"http://localhost:3000/","https://nuvio.in/","https://manageecom.com:8081/","https://manageecom.com:8083/","https://manageecom.com:8084/"}, maxAge = 3600)
@RestController
public class ProductControllers {
	@Autowired
	CategorysRepository categorysRepository;
	@Autowired
	BrandRepository brandRepository;
	
	
	@GetMapping("/product-categories")
	public String getAllCategorys() {
		List<Categorys> cats=categorysRepository.findAll();
		return cats.toString();
	}
	
	@GetMapping("/brands")
	public String getAllBrands() {
		List<Brands> brs=brandRepository.findAll();
		return brs.toString();
		
	}
}
