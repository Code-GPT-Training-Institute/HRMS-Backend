package com.trainings.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainings.jpa.service.UserService;
import com.trainings.jpa.token.TokenService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	TokenService tokenService;
	
	@GetMapping("/{username}/{password}")
	public ResponseEntity<Boolean> isvaliduser(@PathVariable String username,@PathVariable String password) {
		boolean status = userService.isValiduser(username,password);
		return new ResponseEntity<>(status,HttpStatus.OK);
		
	}
	
	@GetMapping("/generateToken/{username}")
	public ResponseEntity<String> generateToken(@PathVariable String username) {
		String token =  tokenService.generateToken(username);
	    return new ResponseEntity<String>(token,HttpStatus.OK);
	}
	
	@GetMapping("/validateToken/{token}")
	public String validateToken(@PathVariable String token){
		if(tokenService.validateToken(token)) {
			return "Token is valid";
		}else {
			return "Token is invalid";
		}
		
	}
	
}
	       
	       
