package com.trainings.jpa.token;

import java.sql.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	public static final String secretkey = "jBdZVEtze4eogkVex1VqUw3l/qVhi8ERc2n6MRGHoJyZHRdnq4c/m8YXA0nfJmc+fdsmYvo/m7hA\r\n"
			+ "CKYGwwMQCQ=="; 

    public String generateToken(String username) {
        long expirationTimeMillis = System.currentTimeMillis() + 604800000 ; 
        Date expirationDate = new Date(expirationTimeMillis);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secretkey)
                .compact();
    }
    
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            
            return false;
        }
    }

}
