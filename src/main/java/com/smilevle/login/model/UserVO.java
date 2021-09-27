package com.smilevle.login.model;

import java.util.Date;

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
	private String userType;
	private String ban;
	private Date banDate;

}
