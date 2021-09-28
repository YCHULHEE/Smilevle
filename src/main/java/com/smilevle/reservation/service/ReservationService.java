package com.smilevle.reservation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smilevle.reservation.model.ReservationVO;
import com.smilevle.reservation.repository.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;

	public List<ReservationVO> getReservationList() {
		return reservationRepository.getReservationList();
	}

	public void addReservation(ReservationVO reservationVO) {
		reservationRepository.addReservation(reservationVO);

	}

//	public ReservationVO selectByResNum(int resNum) {
//		return reservationRepository.selectByResNum(resNum);
//	}

	// 하나로 조회
//	public ReservationVO selectByMemberId(String memberId) {
//		return reservationRepository.selectByMemberId(memberId);
//	}

	public List<ReservationVO> selectByMemberId(String memberId) {
		return reservationRepository.selectByMemberId(memberId);
	}

	public int getResNum() {
		return reservationRepository.getResNum();
	}

	public void deleteByResNum(int resNum) {
		reservationRepository.deleteByResNum(resNum);
	}

	public List<Date> selectByTitleToCheckIn(String title) {
		return reservationRepository.selectByTitleToCheckIn(title);
	}
	
	public int getCount(String checkInDate,String checkOutDate) {
		return reservationRepository.getCount(checkInDate, checkOutDate);
	}
//
	public List<Date> selectByTitleToCheckOut(String title) {
		return reservationRepository.selectByTitleToCheckOut(title);
	}

	
	
//	public String[] hi(ReservationVO vo) {
//
//		List list = new ArrayList<>();
//		String checkInStr = "2021-09-29";
//		
//		int[] yearMonthDay = new int[3];				
//		
//		// 반복 횟수 받아오는거
//		int count = reservationRepository.getCount();
//
//		// list = // vo 객체 넣는다.
//
//		for (int i = 0; i < list.size(); i++) {
//			// list.get(i).getCheckInDate();
//			String[] str1 = checkInStr.split("-");
//			yearMonthDay  = new int[3];
//			for(int k = 0; k < 3; k++) {
//				yearMonthDay[k] = Integer.parseInt(str1[k]);
//			}
//			
//			// 반복 횟수 받아오는거
//			// count 뭐시라
//
//			checkInStr = vo.getCheckInDate();
//
//			for (int j = 0; j < count; j++) {
//				
//				if()
//				
//				yearMonthDay[2]++;
//			}
//		}
//
//		return null;
//	}

}
