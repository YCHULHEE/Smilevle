package com.smilevle.review.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smilevle.review.model.ReviewPageVO;
import com.smilevle.review.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping({"", "/"})
	public String reviewPage(ReviewPageVO reviewPageVO, Model model, 
							@RequestParam(value = "nowPage", required = false, defaultValue = "1") String nowPage, 
							@RequestParam(value = "cntPerPage", required = false, defaultValue = "8") String cntPerPage) {
		int reviewCnt = reviewService.reviewCount();
		reviewPageVO = new ReviewPageVO(reviewCnt, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("reviewPageVO", reviewPageVO);
		model.addAttribute("reviewPage", reviewService.getReviewPage(reviewPageVO));
		return "/review/review";
	}
	@RequestMapping("/read")
	public String readReview(Model model, @RequestParam(value = "no", required = true) Integer reviewNo) {
		System.out.println("Controller reviewNO: " + reviewNo);
		model.addAttribute("reviewData", reviewService.selectById(reviewNo));
		return "/review/readReview";
	}
}
