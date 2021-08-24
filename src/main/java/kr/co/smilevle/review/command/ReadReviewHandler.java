package kr.co.smilevle.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.review.model.Review;
import kr.co.smilevle.review.service.ReadReviewService;
import kr.co.smilevle.review.service.ReviewNotFoundException;

public class ReadReviewHandler implements CommandHandler{
	private ReadReviewService readService = new ReadReviewService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noVal = request.getParameter("no");
		int reviewNum = Integer.parseInt(noVal);
		try {
			Review review = readService.getReview(reviewNum, true);
			request.setAttribute("reviewData", review);
			return "/WEB-INF/views/readReview.jsp";
		} catch(ReviewNotFoundException e) {
			request.getServletContext().log("no review", e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
		
	}
}
