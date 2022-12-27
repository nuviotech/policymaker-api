package com.sellerPolicy.Api.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sellerPolicy.Api.entity.Categorys;
import com.sellerPolicy.Api.entity.MarketPlace;
import com.sellerPolicy.Api.entity.Product;
import com.sellerPolicy.Api.entity.ProductReviews;
import com.sellerPolicy.Api.entity.Seller;
import com.sellerPolicy.Api.repo.CategorysRepository;
import com.sellerPolicy.Api.repo.MarketPlacerRepository;
import com.sellerPolicy.Api.repo.ProductRepository;
import com.sellerPolicy.Api.repo.ProductReviewRepository;
import com.sellerPolicy.Api.repo.SellerRepository;

import HelperClasses.Helper;

@RestController
public class MainController {
	
	@Autowired
	SellerRepository sellerRepository;
	@Autowired
	MarketPlacerRepository marketPlacerRepository;
	@Autowired
	CategorysRepository  categorysRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductReviewRepository productReviewRepository;
	
	@GetMapping("/seller/{category}")
	public String searchSeller(@PathVariable String category) {
		
		System.out.println("Hello i am on.. "+category);
		Categorys categorys=categorysRepository.findByCatergoryName(category);
		

		ObjectMapper om=new ObjectMapper();
		String str="Nan";
		List<Seller> sl=new ArrayList<>();
		try {
			for(Seller s:categorys.getSellerList()) {
				Seller sd=new Seller();
				sd.setNameOfCompany(s.getNameOfCompany());
				sd.setComponyUrl(s.getComponyUrl());
				sd.setFirstName(s.getFirstName());
				sd.setLastName(s.getLastName());
				sd.setBussinessAddr(s.getBussinessAddr());
				sd.setEmailAddr(s.getEmailAddr());
				sd.setTypeOfCompany(s.getTypeOfCompany());
				sd.setGstNo(s.getGstNo());
				sd.setPhoneNumber(s.getPhoneNumber());
				sd.setPincode(s.getPincode());
				sd.setCountry(s.getCountry());
				sd.setState(s.getState());
				
				sl.add(sd);
			}
		
			System.out.println(sl);
			str = om.writeValueAsString(sl);
			System.out.println(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;

		
	}
	
	@GetMapping("/marketplace/{category}")
	public String searchMarketplace(@PathVariable String category) {
		
		System.out.println("Hello i am on.. "+category);
		Categorys categorys=categorysRepository.findByCatergoryName(category);
		

		ObjectMapper om=new ObjectMapper();
		String str="Nan";
		List<MarketPlace> sl=new ArrayList<>();
		try {
			for(MarketPlace s:categorys.getMarketplaceList()) {
				MarketPlace sd=new MarketPlace();
				sd.setNameOfCompany(s.getNameOfCompany());
				sd.setComponyUrl(s.getComponyUrl());
				sd.setFirstName(s.getFirstName());
				sd.setLastName(s.getLastName());
				sd.setBussinessAddr(s.getBussinessAddr());
				sd.setEmailAddr(s.getEmailAddr());
				sd.setTypeOfCompany(s.getTypeOfCompany());
				sd.setGstNo(s.getGstNo());
				sd.setPhoneNumber(s.getPhoneNumber());
				sd.setPincode(s.getPincode());
				sd.setCountry(s.getCountry());
				sd.setState(s.getState());
				
				sl.add(sd);
			}
		
			System.out.println(sl);
			str = om.writeValueAsString(sl);
			System.out.println(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	@GetMapping("/getProductRefId/{catId}/{title}/{hsnId}")
	public String getProductRefId(@PathVariable String catId,@PathVariable String title,@PathVariable String hsnId) {
		String productRefId="none";
		System.out.println(catId+" " +title+" "+hsnId);
		try {
			Product p=new Product();
			productRefId="PRD_RF_ID_"+Helper.getRandomNumber();
			p.setProduct_ref_id(productRefId);
			p.setCategoryId(catId);
			p.setCreatedDateTime(new Date());
			p.setHsnNo(hsnId);
			p.setTitle(title);
			productRepository.save(p);
		}catch(Exception e) {
			productRefId="none";
			e.printStackTrace();
		}
		return productRefId;
	}
	
	@GetMapping("/getReviews/{prd_ref_id}")
	public String  getProductReviews(@PathVariable String prd_ref_id){
		ObjectMapper om=new ObjectMapper();
		String str="wrong product ref id !!!";
		try {
		List<ProductReviews> prList=new ArrayList<>();
		Product p=productRepository.getById(prd_ref_id);
		for(ProductReviews pr:p.getProductReviews()) {
			ProductReviews productReview=new ProductReviews();
			productReview.setReviwerId(pr.getReviwerId());
			productReview.setFeedback(pr.getFeedback());
			productReview.setImagUrls(pr.getImagUrls());
			productReview.setDate(pr.getDate());
			productReview.setRating(pr.getRating());
			prList.add(productReview);
		}
		str= om.writeValueAsString(prList);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	
		
}
