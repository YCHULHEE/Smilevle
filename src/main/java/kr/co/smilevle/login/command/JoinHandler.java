package kr.co.smilevle.login.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.login.service.DuplicateIdException;
import kr.co.smilevle.login.service.JoinRequest;
import kr.co.smilevle.login.service.JoinService;



public class JoinHandler implements CommandHandler{
	
	private static final String FORM_VIEW="/WEB-INF/views/login/joinForm.jsp";
	private JoinService joinService=new JoinService();

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
	
		return FORM_VIEW;
	}
	
	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		
		JoinRequest joinReq=new JoinRequest();
		joinReq.setId(request.getParameter("id"));
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
			return "/WEB-INF/views/login/joinSuccess.jsp";
		}catch(DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return  FORM_VIEW;		
		}		
	}

}
