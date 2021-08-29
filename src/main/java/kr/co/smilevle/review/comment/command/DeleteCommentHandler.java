package kr.co.smilevle.review.comment.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.login.service.User;
import kr.co.smilevle.review.comment.service.DeleteCommentRequest;
import kr.co.smilevle.review.comment.service.DeleteCommentService;
import kr.co.smilevle.review.service.PermissionDeniedException;

public class DeleteCommentHandler implements CommandHandler{
	private DeleteCommentService deleteService = new DeleteCommentService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		User authUser = (User) req.getSession().getAttribute("authUser");
		String comNoVal = req.getParameter("commNo");
		int commentNum = Integer.parseInt(comNoVal);
		String noVal = req.getParameter("rvwNum");
		int reviewNo = Integer.parseInt(noVal);
		
		DeleteCommentRequest delReq = new DeleteCommentRequest(authUser.getId(), commentNum);
		req.setAttribute("delReq", delReq);
		
		if(!canDelete(authUser, delReq)) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
		try {
			deleteService.deleteComment(delReq);
			return "review_read.do?no=" + reviewNo;
		} catch(PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	private boolean canDelete(User authUser, DeleteCommentRequest delReq) {
		return authUser.getId().equals(delReq.getUserId());
	}
	

}
