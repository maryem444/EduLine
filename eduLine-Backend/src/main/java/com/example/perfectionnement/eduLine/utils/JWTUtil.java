package com.example.perfectionnement.eduLine.utils;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

//@Component
public class JWTUtil {

	public String extractuserName(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	public String generateToken (UserDetails userdetails) {
		return generateToken(new HashMap<>(), userdetails);
	}
	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String userName = extractuserName(token);
		return (userName.equals(userDetails.getUsername())) && !isTokenExpired (token);
	}
	private <T> T extractClaim(String token, Function<Claims,T> claimsResolvers) {
		final Claims claims = extractAllClaims(token);
		return claimsResolvers.apply(claims);
	}
	private String generateToken(Map<String,Object> extraClaims, UserDetails userdetails) {
		return Jwts.builder().setClaims(extraClaims).setSubject(userdetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
				.signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
	}
	private String generateRefreshToken(Map<String,Object> extraClaims, UserDetails userdetails) {
		return Jwts.builder().setClaims(extraClaims).setSubject(userdetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 604800000))
				.signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
	}
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token)
				.getBody();
	}
	
	private Key getSigningKey() {
		byte[] keyBytes = Decoders.BASE64.decode("413F4428472B6250655368566D5970337336763979244226452948404D6351");
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	
}
