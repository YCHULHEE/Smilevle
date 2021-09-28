package com.smilevle.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smilevle.login.model.MemberVO;
import com.smilevle.login.repository.MemberRepository;
import com.smilevle.login.service.MemberPage;

@Service
public class MemberService {
	@Autowired
	MemberRepository memberRepository;

	public MemberPage getMemberPage(int pageNum, String memberId, int size) {

		int total = memberRepository.selectCount(memberId);

		List<MemberVO> memberList = memberRepository.getMemberList((pageNum - 1) * size, size, memberId);

		return new MemberPage(total, pageNum, size, memberList);
	}
}
