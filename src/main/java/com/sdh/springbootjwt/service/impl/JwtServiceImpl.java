package com.sdh.springbootjwt.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import org.springframework.stereotype.Service;

import com.sdh.springbootjwt.dto.ReqUserDto;
import com.sdh.springbootjwt.service.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JwtServiceImpl implements JwtService {

	private final String secretKey = "SdhSpringBootJwtProjectSecretKey";

	@Override
	public String create(ReqUserDto requestBody) {
		Key key = Keys.hmacShaKeyFor(generateKey());
		
		String jws = Jwts.builder()
						.setHeaderParam("typ", "JWT")
						.setSubject("user")
						.claim("uid", requestBody.getUid())
						.claim("email", requestBody.getEmail())
						.signWith(key, SignatureAlgorithm.HS256)
						.compact();
		
		return jws;
	}



	@Override
	public Jws<Claims> getJwsClaims(String jws) {
		Jws<Claims> claims = Jwts.parser()
								.setSigningKey(generateKey())
								.parseClaimsJws(jws);
		
		return claims;
	}
	
	private byte[] generateKey() {
		byte[] key = null;
		try {
			key = secretKey.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.debug("generate key fail : {} ", e);
//			e.printStackTrace();
		}

		return key;
	}

}
