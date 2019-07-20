package com.sdh.springbootjwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdh.springbootjwt.dto.ReqUserDto;
import com.sdh.springbootjwt.service.JwtService;

@RequestMapping("/user")
@RestController
public class JwtController {

	private final JwtService jwtService;

	public JwtController(JwtService jwtService) {
		this.jwtService = jwtService;
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody ReqUserDto requestBody) {
		String jws = jwtService.create(requestBody);
		return ResponseEntity.status(HttpStatus.OK).body(jws);
	}

}
