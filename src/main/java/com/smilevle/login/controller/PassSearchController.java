package com.smilevle.login.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smilevle.login.model.MemberVO;
import com.smilevle.login.service.PassSearchService;
import com.smilevle.login.service.SearchFailException;

@Controller
@RequestMapping("/search")
public class PassSearchController {
	private static final String FORM_VIEW="/login/passSearchForm";
	@Autowired
	private PassSearchService passSearchService;

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
	
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return FORM_VIEW;
	}
	
	@RequestMapping("")
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=trim(request.getParameter("memberId"));
		String email=trim(request.getParameter("email"));
		
		Map<String,Boolean> errors=new HashMap<>();
		request.setAttribute("errors", errors);
		
		if(id==null||id.isEmpty())errors.put("memberId",Boolean.TRUE);
		if(email==null||email.isEmpty())errors.put("email", Boolean.TRUE);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			MemberVO memberVO=passSearchService.search(id, email);
			request.getSession().setAttribute("searchUser", memberVO);
			return "/login/passSearchSuccess";
			
			
		}catch(SearchFailException e) {
			errors.put("idOrMailNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}		
	}
	
	private String trim(String str) {
		
		return str==null?null:str.trim();
	}

}
