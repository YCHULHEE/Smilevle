package com.smilevle.login.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smilevle.login.model.MemberVO;
import com.smilevle.login.repository.MemberRepository;

@Service
public class PassSearchService {
	private MemberRepository memberRepository;
	
	public PassSearchService(MemberRepository memberRepository) {
		this.memberRepository=memberRepository;
	}
	
	public MemberVO search(String memberId, String email) {
		
			MemberVO memberVO=memberRepository.SelectById(memberId);
			if(memberVO==null) {
				throw new SearchFailException();
			}
			if(!memberVO.matchEmail(email)) {
				throw new SearchFailException();
			}
			return new MemberVO((memberVO).getMemberId(), (memberVO).getName(),(memberVO).getPassword(),(memberVO).getRegDate(),(memberVO).getEmail(),(memberVO).getGender(),
					(memberVO).getBirthday(),(memberVO).getPhonenum(),(memberVO).getUserType(),(memberVO).getBan());
		
	}

}
