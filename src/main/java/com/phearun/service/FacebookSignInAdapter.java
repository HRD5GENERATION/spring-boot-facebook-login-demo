package com.phearun.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import com.phearun.repository.UserRepository;

@Component
public class FacebookSignInAdapter implements SignInAdapter {

	private UserRepository userRepository;
	
	public FacebookSignInAdapter() {
		System.out.println("=>FacebookSigninAdapter");
	}
	
	@Autowired
	public void setUserRepository(UserRepository userRepository){
		System.out.println("=>UserRepository: " + userRepository);
		this.userRepository = userRepository;
	}
	
	@Override
	public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
		
		System.out.println(localUserId); //localUserId : return from execute method of ConnectionSignUp
		
		//TODO: Authenticate successfully!
		System.out.println("=> Success authenticating...");
		
		if(userRepository.login(localUserId))
			//Set session to spring security
			SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(connection.getDisplayName(), null, Arrays.asList(new SimpleGrantedAuthority("FACEBOOK_USER"))));
		
		return "/"; //return to other page or null for default( url: "/")
	}
}