package com.smilevle.login.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smilevle.login.model.MemberVO;
import com.smilevle.login.repository.MemberRepository;

@Service
public class JoinService {
private MemberRepository memberRepository;

public JoinService(MemberRepository memberRepository) {
	this.memberRepository=memberRepository;
}
	
	public void join(JoinRequest joinReq) throws IOException{
				
			MemberVO memberVO=memberRepository.SelectById(joinReq.getMemberId());
			if(memberVO!=null) {
				throw new DuplicateIdException();
			}	
			memberRepository.insertMember(new MemberVO(
					joinReq.getMemberId(),
					joinReq.getName(),
					joinReq.getPassword(),
					new Date(),
					joinReq.getEmail(),
					joinReq.getGender(),
					joinReq.getBirthday(),
					joinReq.getPhonenum(),
					"normal",
					"0",
					new Date(2999-12-31)
					)
					);
			
			
		
	}

}
