package com.phearun.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.phearun.model.User;

@Repository
public class UserRepository {
	
	public UserRepository() {
		System.out.println("=>UserRepository!");
	}
	
	private List<User> users = new ArrayList<>();
	
	public void save(User user){
		users.add(user);
	}
	
	public boolean login(String facebookId){
		System.out.println("=>" + facebookId);
		return true;
	}
	
}
