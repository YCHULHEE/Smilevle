package kr.co.smilevle.review.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.login.service.User;
import kr.co.smilevle.review.model.Review;
import kr.co.smilevle.review.service.ModifyRequest;
import kr.co.smilevle.review.service.ModifyReviewService;
import kr.co.smilevle.review.service.ReadReviewService;
import kr.co.smilevle.review.service.ReviewNotFoundException;

public class ModifyReviewHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/views/review/modifyReview.jsp";
	
	private ReadReviewService readService = new ReadReviewService();
	private ModifyReviewService modifyService = new ModifyReviewService();
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request, response);
		} else if(request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}


	private String processForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String noVal = request.getParameter("no");
			int no = Integer.parseInt(noVal);
			Review review = readService.getReview(no, false);
			User authUser = (User) request.getSession().getAttribute("authUser");
			if(!canModify(authUser, review)) {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			ModifyRequest modReq = new ModifyRequest(
					authUser.getId(), 
					no, 
					review.getTitle(), 
					review.getAreacode(), 
					review.getLocationName(), 
					review.getRate(), 
					review.getContent());
			request.setAttribute("modReq", modReq);
			return FORM_VIEW;
		} catch(ReviewNotFoundException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}


	private boolean canModify(User authUser, Review review) {
		String writerId = review.getWriter().getId();
		return authUser.getId().equals(writerId);
	}


	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User authUser = (User) request.getSession().getAttribute("authUser"); 
		String noVal = request.getParameter("no");
		int no = Integer.parseInt(noVal);
		
		ModifyRequest modReq = new ModifyRequest(
				authUser.getId(), 
				no, 
				request.getParameter("title"), 
				request.getParameter("areacode"), 
				request.getParameter("locationName"), 
				request.getParameter("rate"), 
				request.getParameter("content"));
		request.setAttribute("modReq", modReq);
		
		Map<String, Boolean> errors = new HashMap<>();
		request.setAttribute("errors", errors);
		modReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			modifyService.modify(modReq);
			return "/WEB-INF/views/review/modifySuccess.jsp";
		} catch(ReviewNotFoundException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}	
	}
}
