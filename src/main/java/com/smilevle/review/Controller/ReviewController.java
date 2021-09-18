package com.smilevle.review.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.smilevle.review.model.PReviewVO;
import com.smilevle.review.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@RequestMapping({"", "/"})
	public String reviewPage(Model model) {
		model.addAttribute("reviewPage", reviewService.getReviewList());
		return "/review/review";
	}
}
