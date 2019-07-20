package com.sdh.springbootjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReqUserDto {

	private int uid;
	private String email;

}
