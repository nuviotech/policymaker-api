package com.App.webApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sellerPolicy.Api.entity.Seller;

//Temp user
//default user for login 
@Service
public class User {
	
	String userName = "Admin@gmail.com" ;
	String password = "$2a$10$hSRKUNyNi3q5cYryoGCTKeLgqMh6yN/BCLUHbfGxcJlD7Fx8dNI8m";
	String firstName = "Admin";
	String role = "marketplace";
	List<Seller> activeSellers = new ArrayList<>();
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public List<Seller> getActiveSellers() {
		return activeSellers;
	}
	public void setActiveSellers(List<Seller> activeSellers) {
		this.activeSellers = activeSellers;
	}
	
}
