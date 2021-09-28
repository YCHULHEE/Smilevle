package com.smilevle.login.service;

import java.util.List;

import com.smilevle.login.model.MemberVO;
import com.smilevle.tour.model.TourVO;

import lombok.Getter;

@Getter
public class MemberPage {
	private int total;
	private int currentPage;
	private List<MemberVO> memberList;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public MemberPage(int total, int currentPage, int size, List<MemberVO> memberList) {
		this.total = total;
		this.currentPage = currentPage;
		this.memberList = memberList;
		if(total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = total / size;
			 
			if (total % size > 0) {
				totalPages++;
			}
			// 
			int modVal = currentPage % 5;
			startPage = currentPage / 5 * 5 + 1;
			if (modVal == 0) startPage -= 5;
			
			endPage = startPage + 4;
	
			if(endPage > totalPages) endPage = totalPages;
		} 
	}
	
	public boolean hasNoStays() {
		return total == 0;
	}
	
	public boolean hasStays() {
		return total > 0;
	}

	
}
