package com.smilevle.login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smilevle.login.service.DuplicateIdException;
import com.smilevle.login.service.JoinRequest;
import com.smilevle.login.service.JoinService;

@Controller
@RequestMapping("/join")
public class JoinController {
	private static final String FORM_VIEW="/login/joinForm";
	@Autowired
	private JoinService joinService;
	
	@RequestMapping("")
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if(request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request,response);
		}else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	@GetMapping("/get")
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}

	@RequestMapping("/post")
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		
		
		JoinRequest joinReq=new JoinRequest();
		joinReq.setMemberId(request.getParameter("memberId"));
		joinReq.setName(request.getParameter("name"));
		joinReq.setPassword(request.getParameter("password"));
		joinReq.setConfirmPassword(request.getParameter("confirmPassword"));
		joinReq.setEmail(request.getParameter("email"));
		joinReq.setGender(request.getParameter("gender"));
		joinReq.setBirthday(request.getParameter("birthday"));
		joinReq.setPhonenum(request.getParameter("phonenum"));
		
		Map<String,Boolean> errors=new HashMap<>();
		request.setAttribute("errors", errors);
		
		joinReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		
		try {
			joinService.join(joinReq);
			return "/login/joinSuccess";
		}catch(DuplicateIdException | IOException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return  FORM_VIEW;		
		}
		
		
		
		
		
	}

}
