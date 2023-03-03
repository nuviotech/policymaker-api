package com.sellerPolicy.Api.jwtAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.App.webApp.service.User;
import com.sellerPolicy.Api.entity.MarketPlace;
import com.sellerPolicy.Api.repo.MarketPlacerRepository;


@Service
public class UserCustomConfigService implements UserDetailsService {
	@Autowired
	MarketPlacerRepository marketPlacerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		try {
			//MarketPlace user = marketPlacerRepository.findByEmailAddr(username);
			User user=null;
			if(username.equals("Admin@gmail.com")) {
				user = new User();
				System.out.println("User is :"+user.getFirstName());
			}
			
			if (user == null) {
				throw new UsernameNotFoundException("Invalid User name or passeword !!");
			} else {
				return new UserCustomConfig(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return null;
	}
}
