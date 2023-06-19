package com.gympower.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.security.Keys;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil {

        private final static String SECRET_KEY = "PEN3P3N3P3N3P3N3P3N3P3N3P3N3P3N3";
	    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;//30 dias

        public static String createToken(String nombre, String email) {

            long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
            Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

            Map<String, Object> claims = new HashMap<>();
            claims.put("nombre", nombre);

	        return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(email)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(expirationDate)
	                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                    .compact();
	    }

        public static UsernamePasswordAuthenticationToken getAuthentication(String token){
            try{
                Claims claims = Jwts.parserBuilder()
                                    .setSigningKey(SECRET_KEY.getBytes())
                                    .build()
                                    .parseClaimsJws(token)
                                    .getBody();
                                    
                String email = claims.getSubject();

                return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
            }catch(JwtException e){
                return null;
            }
        }
}