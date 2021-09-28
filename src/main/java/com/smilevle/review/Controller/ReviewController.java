package com.smilevle.review.Controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.smilevle.config.util.AreacodeConverter;
import com.smilevle.login.model.UserVO;
import com.smilevle.review.model.AttachVO;
import com.smilevle.review.model.ReviewPageVO;
import com.smilevle.review.model.ReviewVO;
import com.smilevle.review.service.ReviewService;
import com.smilevle.tour.model.TourVO;
import com.smilevle.tour.service.TourData;
import com.smilevle.tour.service.TourService;

@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private TourService	tourService;
	
	@RequestMapping("/review")
	public String reviewPage(HttpServletRequest request, HttpServletResponse response, ReviewPageVO reviewPageVO, Model model, 
							@RequestParam(value = "pageNo", required = false, defaultValue = "1") String nowPage, 
							@RequestParam(value = "cntPerPage", required = false, defaultValue = "8") String cntPerPage,
							@RequestParam(value = "searchWord", required = false, defaultValue = "") String searchWord, 
							@RequestParam(value = "searchAreacode", required = false, defaultValue = "") String searchAreacode, 
							@RequestParam(value = "myId", required = false, defaultValue = "") String myId,
							@RequestParam(value = "starRate", required = false, defaultValue = "") String starRate) {
		int reviewCnt = reviewService.reviewCount(searchWord, searchAreacode, myId, starRate);
		reviewPageVO = new ReviewPageVO(reviewCnt, Integer.parseInt(nowPage));
		model.addAttribute("reviewPageVO", reviewPageVO);
		System.out.println(reviewPageVO);
		model.addAttribute("reviewPage", reviewService.getReviewPage(reviewPageVO, searchWord, searchAreacode, myId, starRate));
		
		reviewService.getReviewPage(reviewPageVO, searchWord, searchAreacode, myId, starRate);
		

		
		return "/review/review";
	}
	@RequestMapping("/review_read")
	public String readReview(Model model, @RequestParam(value = "no", required = true) Integer reviewNo) {
		model.addAttribute("reviewData", reviewService.selectById(reviewNo));
		return "/review/readReview";
	}
	
	@RequestMapping("/review_write")
	public String viewWritePage(Model model, @RequestParam(value = "stayId") Integer stayId) {
		TourData tourData = tourService.getTour(stayId, false);
		TourVO tourVO = tourData.getTourVO();
		
		model.addAttribute("stayId", stayId);
		model.addAttribute("stayAreacode", tourVO.getAreaCode());
		model.addAttribute("stayArea", AreacodeConverter.getKey(tourVO.getAreaCode()));
		model.addAttribute("title", tourVO.getTitle());
		return "/review/newReview";
	}
	
	@RequestMapping("/review_writeAction")
	public String writeReview(HttpServletRequest request, HttpServletResponse response, Model model, ReviewVO reviewVO, AttachVO attachVO) {
		UserVO authUser = (UserVO) request.getSession().getAttribute("authUser");
		reviewVO.setWriterId(authUser.getMemberId());
		reviewVO.setWriterName(authUser.getName());
		reviewVO.setRegDate(new Date());
		reviewVO.setModDate(new Date());
		reviewVO.setReviewNo(reviewService.getReviewNo());
		reviewService.insertReview(reviewVO);
		
		String fileUrl = (String) (request.getSession(false).getAttribute("fileUrl"));
		if(fileUrl == null) {
			attachVO = new AttachVO(null, reviewVO.getReviewNo(), "");
		} else {
			attachVO = new AttachVO(null, reviewVO.getReviewNo(), fileUrl);
		}
		reviewService.insertAttach(attachVO);
		
		model.addAttribute("newReviewNo", reviewVO.getReviewNo());
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
		model.addAttribute("stayArea", AreacodeConverter.getKey(reviewVO.getAreacode()));
		return "/review/modifyReview";
	}
	
	@RequestMapping("/review_modifyAction")
	public String modifyReview(Model model, HttpServletRequest request, HttpServletResponse response, ReviewVO reviewVO, AttachVO attachVO) {
		reviewVO.setModDate(new Date());
		String fileUrl = (String) (request.getSession(false).getAttribute("fileUrl"));
		if(fileUrl != null) {
			attachVO = new AttachVO(null, reviewVO.getReviewNo(), fileUrl);
		} else {
			attachVO = reviewService.selectAttachById(reviewVO.getReviewNo());
		}
		reviewService.modifyReview(reviewVO);
		reviewService.modifyAttach(attachVO);
		model.addAttribute("modifiedReviewNo", reviewVO.getReviewNo());
		request.getSession(false).removeAttribute("fileUrl");
		return "/review/modifySuccess";
	}
}
