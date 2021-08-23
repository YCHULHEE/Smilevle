package kr.co.smilevle.login.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.login.member.Member;
import kr.co.smilevle.login.service.PassSearchService;
import kr.co.smilevle.login.service.SearchFailException;

public class PassSearchHandler implements CommandHandler{
	
	private static final String FORM_VIEW="/WEB-INF/views/login/passSearchForm.jsp";
	private PassSearchService passSearchService=new PassSearchService();

	@Override
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
	

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=trim(request.getParameter("id"));
		String email=trim(request.getParameter("email"));
		
		Map<String,Boolean> errors=new HashMap<>();
		request.setAttribute("errors", errors);
		
		if(id==null||id.isEmpty())errors.put("id",Boolean.TRUE);
		if(email==null||email.isEmpty())errors.put("email", Boolean.TRUE);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			Member member=passSearchService.search(id, email);
			request.getSession().setAttribute("searchUser", member);
			return "/WEB-INF/views/login/passSearchSuccess.jsp";
			
			
		}catch(SearchFailException e) {
			errors.put("idOrMailNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}		
	}
	
	private String trim(String str) {
		
		return str==null?null:str.trim();
	}

	

}
