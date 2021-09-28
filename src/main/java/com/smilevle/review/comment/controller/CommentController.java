package com.smilevle.review.comment.controller;

import java.text.SimpleDateFormat;
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

import com.smilevle.login.model.UserVO;
import com.smilevle.review.comment.model.CommentVO;
import com.smilevle.review.comment.service.CommentService;


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
			commentJSON.put("commentNo", comment.getCommentNo().toString());
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			commentJSON.put("regdate", format1.format(comment.getRegdate()));
			commentJSON.put("reviewNo", comment.getReviewNo().toString());
			commentJSON.put("writerId", comment.getWriterId());
			commentJSON.put("content", comment.getContent());
			result.add(commentJSON);	
		}
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
	}
	
	@RequestMapping("/comment_write")
	public void writeComment(HttpServletRequest request, HttpServletResponse response, 
							 @RequestParam(value = "no", required = true) Integer reviewNo, CommentVO commentVO) {
		commentVO.setCommentNo(commentService.getCommentNo());
		commentVO.setReviewNo(reviewNo);
		UserVO authUser = (UserVO) request.getSession().getAttribute("authUser");
		commentVO.setWriterId(authUser.getMemberId());
		commentVO.setRegdate(new Date());
		commentService.writeComment(commentVO);
	}
	
	@RequestMapping("/comment_delete")
	public void deleteComment(Integer commentNo) {
		commentService.deleteComment(commentNo);
	}
}
