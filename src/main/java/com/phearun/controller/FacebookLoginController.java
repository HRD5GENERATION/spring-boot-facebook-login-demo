package com.phearun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacebookLoginController {

	@GetMapping(value={"/login", "/signup"})
	public String login(){
		return "login";
	}
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
	
}
