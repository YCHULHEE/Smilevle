package com.smilevle.login.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberVO {
	private String memberId;
	private String name;
	private String password;
	private Date regDate;
	private String email;
	private String gender;
	private String birthday;
	private String phonenum;
	
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}
	
	public boolean matchEmail(String mail) {
		return email.equals(mail);
	}

}
