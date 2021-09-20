package com.smilevle.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.smilevle.review.model.PReviewVO;
import com.smilevle.review.model.ReviewPageVO;
import com.smilevle.review.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	
	public List<PReviewVO> getReviewPage(ReviewPageVO reviewPageVO) {
		return reviewRepository.getReviewList(reviewPageVO);
	}
	
	public int reviewCount() {
		return reviewRepository.reviewCount();
	}
}
