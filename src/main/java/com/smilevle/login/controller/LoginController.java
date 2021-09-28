package com.smilevle.login.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.smilevle.login.model.UserVO;
import com.smilevle.login.service.LoginFailException;
import com.smilevle.login.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	private static final String FORM_VIEW="/login/loginForm";
	@Autowired
	private LoginService loginService;
	
	
	
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
	
	@PostMapping("/post")
	private String processSubmit(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String id=trim(request.getParameter("memberId"));
		String password=trim(request.getParameter("password"));
		
		
		
		Map<String,Boolean> errors=new HashMap<>();
		request.setAttribute("errors", errors);
		
		
		if(id==null||id.isEmpty())errors.put("memberId",Boolean.TRUE);
		if(password==null||password.isEmpty())errors.put("password", Boolean.TRUE);
		
		if(!errors.isEmpty()) {
			System.out.println(errors);
			return FORM_VIEW;
		}
//-------------------------------------------------------------------------------------------------------------		
		try {
			UserVO userVO=loginService.login(id, password);
			request.getSession().setAttribute("authUser", userVO);
			response.sendRedirect("/");
			return null;
			
			
		}catch(LoginFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			
			return FORM_VIEW;
			
		}	
		
	
	}
	


	private String trim(String str) {
		
		return str==null?null:str.trim();
	}
}
