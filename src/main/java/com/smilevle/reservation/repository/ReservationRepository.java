package com.smilevle.reservation.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smilevle.reservation.model.ReservationVO;


@Repository
public class ReservationRepository {
	private static final String MAPPER_NAME_SPACE="smilevle.mapper.reservationMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//모든예약상황
	public List<ReservationVO> getReservationList(){
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE+"selectReservationAll");
	}
	//예약 insert
	public void addReservation(ReservationVO reservationVO) {
		sqlSessionTemplate.insert(MAPPER_NAME_SPACE+"addReservation",reservationVO);
	}
	//예약번호로 조회
//	public ReservationVO selectByResNum(int resNum) {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("resNum", resNum);
//		return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE +"selectByResNum", params);
//	}
	
	//멤버아이디 하나로 조회
//	public ReservationVO selectByMemberId(String memberId) {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("memberId", memberId);
//		return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE +"selectByMemberId", params);
//	}
	
	public List<ReservationVO> selectByMemberId(String memberId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("memberId", memberId);
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE +"selectByMemberId", params);
	}
	
	
	public int getResNum() {
		return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "getResNum");
	}
	
	public void deleteByResNum(int resNum) {
		sqlSessionTemplate.delete(MAPPER_NAME_SPACE+"deleteByResNum",resNum);
	}
	

}
