package com.trainings.jpa.service.impl;

import com.trainings.jpa.entity.UserEntity;
import com.trainings.jpa.repository.UserRepo;
import com.trainings.jpa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
	@Autowired
	UserRepo userRepo;

	@Override
	public boolean isValidUser(String username, String password) {
		Optional<UserEntity> status = userRepo.findByUsernameAndPassword(username, password);
		return status.isPresent();
	}

}
