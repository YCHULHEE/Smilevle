package com.smilevle.login.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserVO {
	private String memberId;
	private String name;
	private String email;
	private String gender;
	private String birthday;
	private String phonenum;

}
