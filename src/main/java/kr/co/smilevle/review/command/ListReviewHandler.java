package kr.co.smilevle.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.review.service.ListReviewService;
import kr.co.smilevle.review.service.ReviewPage;

public class ListReviewHandler implements CommandHandler{
	
	private ListReviewService listService = new ListReviewService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNoVal = request.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		ReviewPage reviewPage = listService.getReviewPage(pageNo);
		request.setAttribute("reviewPage", reviewPage);
		return "/WEB-INF/views/review/review.jsp";
	}
	
	
}
