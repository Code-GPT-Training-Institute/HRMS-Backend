package com.trainings.jpa.service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.trainings.jpa.entity.UserEntity;
import com.trainings.jpa.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;

	
	public boolean isValiduser(String username,String password) {
		Optional<UserEntity> status = userRepo.findByUsernameAndPassword(username, password);
		return status.isPresent();
	}
	
}
