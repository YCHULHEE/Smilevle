package com.smilevle.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.smilevle.tour.model.TourVO;
import com.smilevle.tour.service.TourData;
import com.smilevle.tour.service.TourService;


@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private TourService tourService;
	
	
	@RequestMapping("/reservation")
	public String reservationPage(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value = "contentId", required = false) String contentId, 
			@RequestParam(value = "title", required = false) String title) {		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		TourData tourData = tourService.getTour(Integer.parseInt(contentId), false);
		TourVO tourVO = tourData.getTourVO();
		UserVO userVO=(UserVO)request.getSession().getAttribute("authUser");		
		//int count;
		
		
		if (userVO==null) {
			return "/login/loginForm";
		}
		List<Date> checkOutList=reservationService.selectByTitleToCheckOut(contentId);
		List<Date> checkInList=reservationService.selectByTitleToCheckIn(contentId);
//		System.out.println("===========>"+checkInList.toString());
//		System.out.println("===========>"+checkOutList.toString());
		int[] checkInCount = new int[checkInList.size()];
		
		
		List<Date> reservationDateList = new ArrayList<Date>();
		//List<String> reservationDate;
		System.out.println("count length: " + checkInCount.length);
		for(int i = 0; i < checkInCount.length; i++) {
			int dateCount = reservationService.getCount(format.format(checkInList.get(i)), format.format(checkOutList.get(i)));
			System.out.println("dateCount: " + dateCount);
			checkInCount[i] = dateCount;
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(checkInList.get(i));
			reservationDateList.add(new Date(cal.getTimeInMillis()));
			for (int j=0; j< checkInCount[i] - 1; j++) {
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
		model.addAttribute("reservationDateList", reservationDateList);
		model.addAttribute("item", tourVO);
		
				
		return "/reservation/reservation";
	}
	
	
	
	@RequestMapping("/insertRes")
	public String insertRes(HttpServletRequest request, HttpServletResponse response,Model model,ReservationVO reservationVO, 
			@RequestParam(value = "checkInD") String checkIn,
			@RequestParam(value = "checkOutD") String checkOut) throws IOException {

		UserVO userVO=(UserVO)request.getSession().getAttribute("authUser");		
		
		if (userVO==null) {
			return "/login/loginForm";
		}
		
		Date checkInDate= java.sql.Date.valueOf(checkIn);
		Date checkOutDate= java.sql.Date.valueOf(checkOut);
		
		reservationVO.setMemberId(userVO.getMemberId());
		reservationVO.setResNum(reservationService.getResNum());		
		reservationVO.setRegDate(new Date());
		reservationVO.setCheckInDate(checkInDate);
		reservationVO.setCheckOutDate(checkOutDate);
		//if reservationVO.
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> checkOutList=reservationService.selectByTitleToCheckOut(reservationVO.getContentId());
		List<Date> checkInList=reservationService.selectByTitleToCheckIn(reservationVO.getContentId());
//		System.out.println("===========>"+checkInList.toString());
//		System.out.println("===========>"+checkOutList.toString());
		int[] checkInCount = new int[checkInList.size()];
		
		
		List<Date> reservationDateList = new ArrayList<Date>();
		//List<String> reservationDate;
		System.out.println("count length: " + checkInCount.length);
		for(int i = 0; i < checkInCount.length; i++) {
			int dateCount = reservationService.getCount(format.format(checkInList.get(i)), format.format(checkOutList.get(i)));
			System.out.println("==============dateCount: " + dateCount);
			checkInCount[i] = dateCount;
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(checkInList.get(i));
			reservationDateList.add(new Date(cal.getTimeInMillis()));
			for (int j=0; j< checkInCount[i] - 1; j++) {
				cal.add(Calendar.DATE, 1);
				reservationDateList.add(new Date(cal.getTimeInMillis()));		
			}
			
		}		
		System.out.println("================="+reservationDateList);			
	
				
		int check=reservationService.getCount(checkIn,checkOut);		
		if(check < 0) {			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('checkIn날짜가 checkOut날짜보다 빨라야 합니다.'); location.href='/reservation?contentId=" + reservationVO.getContentId() + "&title=" + reservationVO.getTitle() + "';</script>");
			out.flush();
			return null;
		}
		for(int k=0;k < reservationDateList.size(); k++) {
			if(checkInDate.compareTo(reservationDateList.get(k)) < 0 && checkOutDate.compareTo(reservationDateList.get(k)) > 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('예약날짜 사이에 이미 예약이 있는 날이 있습니다.'); location.href='/reservation?contentId=" + reservationVO.getContentId() + "&title=" + reservationVO.getTitle() + "';</script>");
				out.flush();
				return null;
			}			
		}
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
		
		model.addAttribute("today", new Date());
		
		
		model.addAttribute("reservationVO",reservationVO);
		
		
		return "/reservation/myResSelect";
	}
	
	@RequestMapping("/deleteRes")
	public String deleteRes(@RequestParam(value = "resNum") Integer resNum) {
		System.out.println(resNum);
		reservationService.deleteByResNum(resNum);
		return "/reservation/deleteRes";
	}
	
		
}
