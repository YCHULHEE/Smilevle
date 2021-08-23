package kr.co.smilevle.login.service;

import java.util.Map;

public class JoinRequest {
	
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	private String email;
	private String gender;
	private String birthday;
	private String phonenum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	

	public boolean isPasswordEqualToConfirm() {
		return password != null &&  password.equals(confirmPassword);
	}
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors,id,"id");
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
