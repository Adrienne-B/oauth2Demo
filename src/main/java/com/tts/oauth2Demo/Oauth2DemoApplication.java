package com.tts.oauth2Demo;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class Oauth2DemoApplication {
	
	 @GetMapping("/user")
	 public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
	     return Collections.singletonMap("name", principal.getAttribute("name"));
	     
	     //To start, let's make a /user endpoint in our main class. Edit OAuth2Demo.application.java. 
	     //This will send back the currently logged-in user. Include RestController and set up the mapping.
	 }
	

	public static void main(String[] args) {
		SpringApplication.run(Oauth2DemoApplication.class, args);
	}

}
