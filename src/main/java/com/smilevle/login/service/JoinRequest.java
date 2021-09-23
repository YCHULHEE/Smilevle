package com.smilevle.login.service;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinRequest {
	private String memberId;
	private String name;
	private String password;
	private String confirmPassword;
	private String email;
	private String gender;
	private String birthday;
	private String phonenum;
	
	public boolean isPasswordEqualToConfirm() {
		return password != null &&  password.equals(confirmPassword);
	}
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors,memberId,"memberId");
		checkEmpty(errors, name, "name");
		checkEmpty(errors, password, "password");
		checkEmpty(errors, confirmPassword, "confirmPassword");
		checkEmpty(errors, email, "email");	
		checkEmpty(errors,gender, "gender");
		checkEmpty(errors, birthday, "birthday");
		checkEmpty(errors, phonenum, "phonenum");
		
		if(!errors.containsKey("confirmPassword")) {	
			if(!isPasswordEqualToConfirm()) {
				errors.put("notMatch",Boolean.TRUE);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
	}


	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if(value==null||value.isEmpty() || value == "")
			errors.put(fieldName, Boolean.TRUE);
	}
}
