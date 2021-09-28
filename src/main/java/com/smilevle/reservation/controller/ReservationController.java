package com.smilevle.reservation.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("contentId", contentId);
		model.addAttribute("title", title);
		
		UserVO userVO=(UserVO)request.getSession().getAttribute("authUser");		
		//int count;
		
		
		if (userVO==null) {
			return "/login/loginForm";
		}
		List<Date> checkOutList=reservationService.selectByTitleToCheckOut(title);
		List<Date> checkInList=reservationService.selectByTitleToCheckIn(title);
		System.out.println("===========>"+checkInList.toString());
		System.out.println("===========>"+checkOutList.toString());
		int[] checkInCount = new int[checkInList.size()];
		
		
		List<Date> reservationDateList = new ArrayList<Date>();
		//List<String> reservationDate;
		System.out.println("count length: " + checkInCount.length);
		for(int i = 0; i < checkInCount.length; i++) {
			int dates = reservationService.getCount(format.format(checkInList.get(i)), format.format(checkOutList.get(i)));
			System.out.println("dates: " + dates);
			checkInCount[i] = dates;
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(checkInList.get(i));
			for (int j=0; j< checkInCount[i]; j++) {
				cal.add(Calendar.DATE, 1);
				reservationDateList.add(new Date(cal.getTimeInMillis()));
				
			}
			
		}
		System.out.println("size: " + reservationDateList.size());
		String[] reservationDate = new String[reservationDateList.size()];
		for(int k = 0; k < reservationDateList.size(); k++) {
			
			String date = format.format(reservationDateList.get(k));
			System.out.println("예약된 날짜 : " + date);
			reservationDate[k] = "'" + date + "'";
		}
		System.out.println(reservationDate.length);
		String dateArray = Arrays.toString(reservationDate);
		System.out.println(dateArray);
		model.addAttribute("reservationDate", dateArray);
		
		
		
				
		return "/reservation/reservation";
	}
	
	
	
	@RequestMapping("/insertRes")
	public String insertRes(HttpServletRequest request, HttpServletResponse response,Model model,ReservationVO reservationVO, 
			@RequestParam(value = "checkInD") String checkIn,
			@RequestParam(value = "checkOutD") String checkOut) {

		UserVO userVO=(UserVO)request.getSession().getAttribute("authUser");		
		
		if (userVO==null) {
			return "/login/loginForm";
		}
		
		reservationVO.setMemberId(userVO.getMemberId());
		reservationVO.setResNum(reservationService.getResNum());		
		reservationVO.setRegDate(new Date());
		reservationVO.setCheckInDate(java.sql.Date.valueOf(checkIn));
		reservationVO.setCheckOutDate(java.sql.Date.valueOf(checkOut));
		//if reservationVO.
		
		
		reservationService.addReservation(reservationVO);		
		model.addAttribute("contentId",reservationVO.getContentId());
		model.addAttribute("title",reservationVO.getTitle());
		
		
		
		return"/reservation/reservationSuccess";
		
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
