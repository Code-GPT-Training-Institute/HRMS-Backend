package com.trainings.jpa.service.impl;

import com.trainings.jpa.entity.UserEntity;
import com.trainings.jpa.repository.UserRepo;
import com.trainings.jpa.service.ITokenService;
import com.trainings.jpa.service.IUserService;
import jakarta.security.auth.message.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	ITokenService tokenService;

	@Override
	public String validateUser(String username, String password) throws AuthException {
		Optional<UserEntity> status = userRepo.findByUsernameAndPassword(username, password);
		if (status.isPresent()) {
			return this.tokenService.generateToken(username);
		}
		throw new AuthException("Invalid login credentials");
	}

	@Override
	public List<UserEntity> getAllUser() {
		return userRepo.findAll();
	}

}
