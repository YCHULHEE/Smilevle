package kr.co.smilevle.review.comment.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.login.service.User;
import kr.co.smilevle.review.comment.service.WriteCommentRequest;
import kr.co.smilevle.review.comment.service.WriteCommentService;

public class WriteCommentHandler implements CommandHandler{
	
	private WriteCommentService writeService = new WriteCommentService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String reviewVal = req.getParameter("rwNum");
		int reviewNunber = Integer.parseInt(reviewVal);
		User user = (User) req.getSession(false).getAttribute("authUser");
		WriteCommentRequest writeReq = createWriteCommentRequest(user, req);
		
		writeService.writeComment(writeReq);
		return null;
	}

	private WriteCommentRequest createWriteCommentRequest(User user, HttpServletRequest req) {
		return new WriteCommentRequest(Integer.parseInt(req.getParameter("rwNum")), 
														user.getId(), 
														req.getParameter("content"));
	}
}
