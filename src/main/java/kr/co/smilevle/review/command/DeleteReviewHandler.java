package kr.co.smilevle.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.login.service.User;
import kr.co.smilevle.review.model.Review;
import kr.co.smilevle.review.service.DeleteReviewRequest;
import kr.co.smilevle.review.service.DeleteReviewService;
import kr.co.smilevle.review.service.PermissionDeniedException;
import kr.co.smilevle.review.service.ReadReviewService;
import kr.co.smilevle.review.service.ReviewNotFoundException;

public class DeleteReviewHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/views/review/deleteSuccess.jsp";
	
	private DeleteReviewService deleteService = new DeleteReviewService();
	private ReadReviewService readService = new ReadReviewService();
		
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User authUser = (User) request.getSession().getAttribute("authUser");
		String noVal = request.getParameter("no");
		int reviewNum = Integer.parseInt(noVal);
		Review review = readService.getReview(reviewNum, false);
		
		DeleteReviewRequest delReq = new DeleteReviewRequest(authUser.getId(), reviewNum);
		request.setAttribute("delReq", delReq);
		
		if(!canDelete(authUser, review)) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
		try {
			deleteService.deleteReview(delReq);
			return FORM_VIEW;
		} catch(ReviewNotFoundException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch(PermissionDeniedException e) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}

	private boolean canDelete(User authUser, Review review) {
		return authUser.getId().equals(review.getWriter().getId());
	}
}
