package com.trainings.jpa.controller;

import com.trainings.jpa.entity.UserEntity;
import com.trainings.jpa.service.IUserService;
import jakarta.security.auth.message.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainings.jpa.service.impl.TokenService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserService userService;
	@Autowired
	TokenService tokenService;
	
	@GetMapping("/auth/{username}/{password}")
	public ResponseEntity<String> validateUser(@PathVariable String username,
												@PathVariable String password) throws AuthException {
		String token = userService.validateUser(username,password);
		return new ResponseEntity<>(token, HttpStatus.OK);
	}

	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserEntity>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
	}
	
//	@GetMapping("/generateToken/{username}")
//	public ResponseEntity<String> generateToken(@PathVariable String username) {
//		String token =  tokenService.generateToken(username);
//	    return new ResponseEntity<String>(token,HttpStatus.OK);
//	}
	
//	@GetMapping("/validateToken/{token}")
//	public String validateToken(@PathVariable String token){
//		if(tokenService.validateToken(token)) {
//			return "Token is valid";
//		}else {
//			return "Token is invalid";
//		}
//	}
	
}
	       
	       
