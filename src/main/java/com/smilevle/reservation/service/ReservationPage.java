package com.smilevle.reservation.service;

import java.util.List;

import com.smilevle.login.model.MemberVO;
import com.smilevle.reservation.model.ReservationVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationPage {
	private int total;
	private int currentPage;
	private List<ReservationVO> reservationList;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public ReservationPage(int total, int currentPage, int size, List<ReservationVO> reservationList) {
		this.total = total;
		this.currentPage = currentPage;
		this.reservationList =reservationList;
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
