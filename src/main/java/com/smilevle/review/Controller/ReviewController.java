package com.smilevle.review.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smilevle.review.model.ReviewPageVO;
import com.smilevle.review.model.ReviewVO;
import com.smilevle.review.service.ReviewService;

@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping("/review")
	public String reviewPage(ReviewPageVO reviewPageVO, Model model, 
							@RequestParam(value = "nowPage", required = false, defaultValue = "1") String nowPage, 
							@RequestParam(value = "cntPerPage", required = false, defaultValue = "8") String cntPerPage) {
		int reviewCnt = reviewService.reviewCount();
		reviewPageVO = new ReviewPageVO(reviewCnt, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("reviewPageVO", reviewPageVO);
		model.addAttribute("reviewPage", reviewService.getReviewPage(reviewPageVO));
		return "/review/review";
	}
	@RequestMapping("/review_read")
	public String readReview(Model model, @RequestParam(value = "no", required = true) Integer reviewNo) {
		System.out.println("Controller reviewNO: " + reviewNo);
		model.addAttribute("reviewData", reviewService.selectById(reviewNo));
		return "/review/readReview";
	}
	
	@RequestMapping("/review_write")
	public String viewWritePage() {
		return "/review/newReview";
	}
	
	@RequestMapping("/review_writeAction")
	public String writeReview(Model model, ReviewVO reviewVO) {
		reviewVO.setWriter_id("example123");
		reviewVO.setWriter_name("박예시");
		reviewVO.setRegDate(new Date());
		reviewVO.setModDate(new Date());
		reviewVO.setReview_no(reviewService.getReviewNo());
		reviewService.insertReview(reviewVO);
		model.addAttribute("newReviewNo", reviewVO.getReview_no());
		return "/review/newReviewSuccess";
	}
}
