package kr.co.smilevle.review.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.login.service.User;
import kr.co.smilevle.review.model.Writer;
import kr.co.smilevle.review.service.SaveAttachRequest;
import kr.co.smilevle.review.service.SaveAttachService;
import kr.co.smilevle.review.service.WriteReviewRequest;
import kr.co.smilevle.review.service.WriteReviewService;

public class WriteReviewHandler implements CommandHandler{
	
	private static final String FORM_VIEW = "/WEB-INF/views/review/newReview.jsp";
	private WriteReviewService writeService = new WriteReviewService();
	private SaveAttachService saveAttachService = new SaveAttachService();
	
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

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Boolean> errors = new HashMap<>();
		request.setAttribute("errors", errors);
		
		// 해야할 일 : 로그인 기능 구현할 때 알맞은 객체로 바꿀 것!
		User user = (User) request.getSession().getAttribute("authUser");
		WriteReviewRequest writeReq = createWriteReviewRequest(user, request);
		writeReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		int newReviewNo = writeService.write(writeReq);
		SaveAttachRequest saveReq = createSaveAttachRequest(newReviewNo, request);
		saveAttachService.write(saveReq);
		request.setAttribute("newReviewNo", newReviewNo);
		
		return "/WEB-INF/views/review/newReviewSuccess.jsp";
	}

	private WriteReviewRequest createWriteReviewRequest(User user, HttpServletRequest request) {
		
		return new WriteReviewRequest(
				new Writer(user.getId(), user.getName()), 
				request.getParameter("title"), 
				request.getParameter("areacode"), 
				request.getParameter("locationName"), 
				request.getParameter("rate"), 
				request.getParameter("content")
				);
	}
	
	private SaveAttachRequest createSaveAttachRequest(int no, HttpServletRequest request) {
		if(request.getSession(false).getAttribute("fileUrl") == null) {
			return new SaveAttachRequest(no);
		} else {
			return new SaveAttachRequest(no, request.getSession(false).getAttribute("fileUrl").toString());
		}
		
	}
	
}
