package com.grupos.back.Security;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
	private final static String ACCES_TOKEN_SECRET = "sAWbl2zf4kvWc1xFU5y9LEadsadsae5dsadaDFSADAas";
	private final static Long ACCES_TOKEN_VALIDITY_SECOND = 2_592_000L;
	
	public static String createToken(String nombre, String email) {
		long expirationTime = ACCES_TOKEN_VALIDITY_SECOND * 1000;
		Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
		
		Map<String, Object> extra = new HashMap<>();
		extra.put("nombre", nombre);
		
		return Jwts.builder()
				.setSubject(email)
				.setExpiration(expirationDate)
				.addClaims(extra)
				.signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
				.compact();
	}
	
	public static UsernamePasswordAuthenticationToken getAuthtentication(String Token) {
		try {
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(ACCES_TOKEN_SECRET.getBytes())
					.build()
					.parseClaimsJws(Token)
					.getBody();
			String email = claims.getSubject();
			return new UsernamePasswordAuthenticationToken(email,null,Collections.emptyList());
		} catch (JwtException e) {
			return null;
		}
		
	}
}
