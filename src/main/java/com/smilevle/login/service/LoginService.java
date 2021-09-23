package com.smilevle.login.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smilevle.login.model.MemberVO;
import com.smilevle.login.model.UserVO;
import com.smilevle.login.repository.MemberRepository;

@Service
public class LoginService {
private MemberRepository memberRepository;

public LoginService(MemberRepository memberRepository) {
	this.memberRepository=memberRepository;
}

	
public UserVO login(String memberId, String password) {
	
		MemberVO memberVO=memberRepository.SelectById(memberId);
		if(memberVO==null) {
			throw new LoginFailException();
		}
		if(!memberVO.matchPassword(password)) {
			throw new LoginFailException();
		}
		return new UserVO((memberVO).getMemberId(), (memberVO).getName(),(memberVO).getEmail(),(memberVO).getGender(),
				(memberVO).getBirthday(),(memberVO).getPhonenum());
			
}

}
