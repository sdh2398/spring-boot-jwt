package com.sdh.springbootjwt.service;

import com.sdh.springbootjwt.dto.ReqUserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public interface JwtService {

	String create(ReqUserDto requestBody);

	Jws<Claims> getJwsClaims(String jws);

}
