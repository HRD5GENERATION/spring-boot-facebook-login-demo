package com.phearun.service;

import java.util.Arrays;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

public class FacebookSignInAdapter implements SignInAdapter {
	
	@Override
	public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
		
		System.out.println(localUserId); //localUserId : return from execute method of ConnectionSignUp
		
		//TODO: Authenticate successfully!
		System.out.println("=> Success authenticating...");
		
		//Set session to spring security
		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(connection.getDisplayName(), null, Arrays.asList(new SimpleGrantedAuthority("FACEBOOK_USER"))));
		
		return "/index"; //return to other page or null for default( url: "/")
	}
}