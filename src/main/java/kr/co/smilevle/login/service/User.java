package kr.co.smilevle.login.service;

public class User {
	
	private String id;
	private String name;
	private String email;
	private String gender;
	private String birthday;
	private String phonenum;
	
	



	public User(String id, String name, String email, String gender, String birthday, String phonenum) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.birthday = birthday;
		this.phonenum = phonenum;
	}


	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}


	public String getGender() {
		return gender;
	}


	public String getBirthday() {
		return birthday;
	}


	public String getPhonenum() {
		return phonenum;
	}
	

}
