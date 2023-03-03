package com.sellerPolicy.Api.jwtAuthentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthentication implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("error : "+authException.getMessage());
		response.sendError(401,"Unauthorized "+authException.getMessage());
		//System.out.println(authException.getStackTrace());		
	}

}
