package com.trainings.jpa.service;

public interface ITokenService {

    public String generateToken(String username);

    public void validateToken(String token);
}
