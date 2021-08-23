package kr.co.smilevle.login.member;

import java.util.Date;

public class Member {
	
	private String id;
	private String name;
	private String password;
	private Date regDate;
	private String email;
	private String gender;
	private String birthday;
	private String phonenum;
	
	public Member(String id, String name, String password, Date regDate, String email, String gender, String birthday,
			String phonenum) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.regDate = regDate;
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

	public String getPassword() {
		return password;
	}

	public Date getRegDate() {
		return regDate;
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
	
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}
	
	public boolean matchEmail(String mail) {
		return email.equals(mail);
	}
	

}
