package com.phearun.service;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

import com.phearun.model.User;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Override
    public String execute(Connection<?> connection) {
    	
    	//TODO: First time login with fb, will execute
    	System.out.println(connection.getImageUrl());
    	System.out.println(connection.getProfileUrl());
    	System.out.println(connection.getKey());
    	User user = new User();
    	
    	user.setUsername(connection.getDisplayName());
    	user.setPassword("123");
    	System.out.println(user);
    	
    	System.out.println("Email: " + connection.fetchUserProfile().getEmail());
    	
    	ConnectionKey connectionKey = connection.getKey();
    	System.out.println("UserId: " + connectionKey.getProviderUserId());
    	
    	return user.getUsername(); //return null to indicate login or sign up not success!, it will return to url /signup
    }
}