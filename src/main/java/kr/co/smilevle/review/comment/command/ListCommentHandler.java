package kr.co.smilevle.review.comment.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.review.comment.service.ListCommentService;

public class ListCommentHandler implements CommandHandler{
	
	private ListCommentService listCommentService = new ListCommentService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noVal = request.getParameter("no");
		int no = 0;
		if(noVal != null) {
			no = Integer.parseInt(noVal);
		}
		JSONArray commentList = listCommentService.getCommentList(no);
		request.setAttribute("commentList", commentList);
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(commentList);
		return null;
	}
	
	
	
}
