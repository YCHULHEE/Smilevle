package com.smilevle.review.Controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smilevle.review.model.AttachVO;
import com.smilevle.review.model.ReviewPageVO;
import com.smilevle.review.model.ReviewVO;
import com.smilevle.review.model.UserVO;
import com.smilevle.review.service.ReviewService;

@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping("/review")
	public String reviewPage(HttpServletRequest request, HttpServletResponse response, ReviewPageVO reviewPageVO, Model model, 
							@RequestParam(value = "nowPage", required = false, defaultValue = "1") String nowPage, 
							@RequestParam(value = "cntPerPage", required = false, defaultValue = "8") String cntPerPage) {
		int reviewCnt = reviewService.reviewCount();
		reviewPageVO = new ReviewPageVO(reviewCnt, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("reviewPageVO", reviewPageVO);
		model.addAttribute("reviewPage", reviewService.getReviewPage(reviewPageVO));
		
		UserVO authUser = new UserVO("example123", "박예시");
		request.getSession().setAttribute("authUser", authUser);
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
	public String writeReview(HttpServletRequest request, HttpServletResponse response, Model model, ReviewVO reviewVO, AttachVO attachVO) {
		reviewVO.setWriter_id("example123");
		reviewVO.setWriter_name("박예시");
		reviewVO.setRegDate(new Date());
		reviewVO.setModDate(new Date());
		reviewVO.setReview_no(reviewService.getReviewNo());
		reviewService.insertReview(reviewVO);
		
		String fileUrl = (String) (request.getSession(false).getAttribute("fileUrl"));
		if(fileUrl == null) {
			attachVO = new AttachVO(null, reviewVO.getReview_no(), "");
		} else {
			attachVO = new AttachVO(null, reviewVO.getReview_no(), fileUrl);
		}
		reviewService.insertAttach(attachVO);
		
		model.addAttribute("newReviewNo", reviewVO.getReview_no());
		request.getSession(false).removeAttribute("fileUrl");
		return "/review/newReviewSuccess";
	}
	
	@RequestMapping("/review_deleteAction")
	public String deleteReview(@RequestParam(value = "no") Integer reviewNo) {
		reviewService.deleteReview(reviewNo);
		return "/review/deleteSuccess";
	}
	
	@RequestMapping("/review_modify")
	public String viewModifyPage(Model model, @RequestParam(value = "no") Integer reviewNo) {
		ReviewVO reviewVO = reviewService.selectById(reviewNo);
		model.addAttribute("modReq", reviewVO);
		return "/review/modifyReview";
	}
	
	@RequestMapping("/review_modifyAction")
	public String modifyReview(Model model, HttpServletRequest request, HttpServletResponse response, ReviewVO reviewVO, AttachVO attachVO) {
		reviewVO.setModDate(new Date());
		System.out.println("modify Controller ~~~~~> " + reviewVO);
		String fileUrl = (String) (request.getSession(false).getAttribute("fileUrl"));
		if(fileUrl == null) {
			attachVO = new AttachVO(null, reviewVO.getReview_no(), "");
		} else {
			attachVO = new AttachVO(null, reviewVO.getReview_no(), fileUrl);
		}
		reviewService.modifyReview(reviewVO);
		reviewService.modifyAttach(attachVO);
		model.addAttribute("modifiedReviewNo", reviewVO.getReview_no());
		request.getSession(false).removeAttribute("fileUrl");
		return "/review/modifySuccess";
		
		
	}
}
