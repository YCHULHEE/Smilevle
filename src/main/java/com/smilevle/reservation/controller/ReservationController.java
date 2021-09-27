package com.smilevle.reservation.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smilevle.login.model.UserVO;
import com.smilevle.reservation.model.ReservationVO;
import com.smilevle.reservation.service.ReservationService;


@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	
	@RequestMapping("/reservation")
	public String reservationPage(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value = "contentId", required = false) String contentId, 
			@RequestParam(value = "title", required = false) String title) {		
		
		model.addAttribute("contentId", contentId);
		model.addAttribute("title", title);
		
		return "/reservation/reservation";
	}
	
	
	
	@RequestMapping("/insertRes")
	public String insertRes(HttpServletRequest request, HttpServletResponse response,Model model,ReservationVO reservationVO) {

		UserVO userVO=(UserVO)request.getSession().getAttribute("authUser");		
		
		if (userVO==null) {
			return "/login/loginForm";
		}
		
		reservationVO.setMemberId(userVO.getMemberId());
		reservationVO.setResNum(reservationService.getResNum());		
		reservationVO.setRegDate(new Date());
		
		reservationService.addReservation(reservationVO);		
		
		return"/reservation/reservation";
		
	}
	
//	@RequestMapping("/myResSelect")
//	public String myResSelct(Model model,@RequestParam(value="memberid")String memberId) {
//		//System.out.println("====>"+id);
//		
//		ReservationVO reservationVO=reservationService.selectByMemberId(memberId);
//		//System.out.println(reservationVO);
//		model.addAttribute("reservationVO",reservationVO);
//		
//		return "/reservation/myResSelect";
//	}
	
	@RequestMapping("/myResSelect")
	public String myResSelct(HttpServletRequest request, HttpServletResponse response,Model model) {
		
		UserVO userVO=(UserVO)request.getSession().getAttribute("authUser");
		
		if (userVO==null) {
			return "/login/loginForm";
		}
		
		
		List<ReservationVO> reservationVO=reservationService.selectByMemberId(userVO.getMemberId());
		
//		System.out.println(reservationVO);
		
//		System.out.println(reservationVO.getTitle());
//		System.out.println(reservationVO.getMemberId());
//		System.out.println(reservationVO.getResNum());
//		System.out.println(reservationVO.getCheckInDate());
//		System.out.println(reservationVO.getCheckOutDate());		
		
		model.addAttribute("reservationVO",reservationVO);
		
		
		return "/reservation/myResSelect";
	}
	
	@RequestMapping("/deleteRes")
	public void deleteRes(@RequestParam(value = "resNum") Integer resNum) {
		System.out.println(resNum);
		reservationService.deleteByResNum(resNum);
		
	}
	
		
}
