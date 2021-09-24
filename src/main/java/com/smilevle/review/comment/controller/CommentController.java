package com.smilevle.review.comment.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smilevle.review.comment.model.CommentVO;
import com.smilevle.review.comment.service.CommentService;
import com.smilevle.review.model.UserVO;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/comment_list")
	public void getCommentList(HttpServletRequest request, HttpServletResponse response, 
							   Model model, @RequestParam(value = "no", required = true) Integer reviewNo) throws Exception {
		List<CommentVO> commentList = commentService.getCommentList(reviewNo);
		JSONArray result = new JSONArray();
		for(CommentVO comment : commentList) {
			JSONObject commentJSON = new JSONObject();
			commentJSON.put("comment_no", comment.getComment_no().toString());
			commentJSON.put("regdate", comment.getRegdate().toString());
			commentJSON.put("review_no", comment.getReview_no().toString());
			commentJSON.put("writer_id", comment.getWriter_id());
			commentJSON.put("content", comment.getContent());
			result.add(commentJSON);	
		}
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
	}
	
	@RequestMapping("/comment_write")
	public void writeComment(HttpServletRequest request, HttpServletResponse response, 
							 @RequestParam(value = "no", required = true) Integer reviewNo, CommentVO commentVO) {
		commentVO.setComment_no(commentService.getCommentNo());
		commentVO.setReview_no(reviewNo);
		UserVO authUser = (UserVO) request.getSession(false).getAttribute("authUser");
		commentVO.setWriter_id(authUser.getId());
		commentVO.setRegdate(new Date());
		commentService.writeComment(commentVO);
	}
}
