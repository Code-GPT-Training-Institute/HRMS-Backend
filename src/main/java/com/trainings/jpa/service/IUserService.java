package com.trainings.jpa.service;

import com.trainings.jpa.entity.UserEntity;
import jakarta.security.auth.message.AuthException;

import java.util.List;

public interface IUserService {
    String validateUser(String username, String password) throws AuthException;

    List<UserEntity> getAllUser();
}
