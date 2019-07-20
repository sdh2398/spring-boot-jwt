package com.sdh.springbootjwt.service.impl;

import org.junit.Assert;
import org.junit.Test;

import com.sdh.springbootjwt.dto.ReqUserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public class JwtServiceImplTest {

	private JwtServiceImpl jwtService = new JwtServiceImpl();

	@Test
	public void test_creatAndGet() {
		int uid = 1234;
		String email = "ehdgus2398@gmail.com";

		ReqUserDto requestBody = new ReqUserDto(uid, email);

		String jws = jwtService.create(requestBody);

		Jws<Claims> jwsClaims = jwtService.getJwsClaims(jws);

		Assert.assertEquals(uid, jwsClaims.getBody().get("uid"));
		Assert.assertEquals(email, jwsClaims.getBody().get("email"));
	}

}
