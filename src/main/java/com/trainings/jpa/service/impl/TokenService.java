package com.trainings.jpa.service.impl;

import java.sql.Date;

import com.trainings.jpa.service.ITokenService;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

@Service
public class TokenService implements ITokenService {
	
	public static final String SECRET_KEY = "MySecretTokenForHRMSApplicationBackendForAuthenticationCreatedForLocalTestingPurposeOnly";

    @Override
    public String generateToken(String username) {
        long expirationTimeMillis = System.currentTimeMillis() + 600000;
        Date expirationDate = new Date(expirationTimeMillis);
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    @Override
    public void validateToken(String token) throws ExpiredJwtException {
        Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
    }
}
