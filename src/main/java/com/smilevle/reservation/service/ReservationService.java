package com.smilevle.reservation.service;

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
	
	public List<ReservationVO> getReservationList(){
		return reservationRepository.getReservationList();
	}
	
	public void addReservation(ReservationVO reservationVO) {		
		reservationRepository.addReservation(reservationVO);
		
		
	}
	
//	public ReservationVO selectByResNum(int resNum) {
//		return reservationRepository.selectByResNum(resNum);
//	}
	
	//하나로 조회
//	public ReservationVO selectByMemberId(String memberId) {
//		return reservationRepository.selectByMemberId(memberId);
//	}
	
	public List<ReservationVO> selectByMemberId(String memberId) {
		return reservationRepository.selectByMemberId(memberId);
	}
	
	public int getResNum( ) {
		return reservationRepository.getResNum();
	}
	
	public void deleteByResNum(int resNum) {
		reservationRepository.deleteByResNum(resNum);
	}
		
}
