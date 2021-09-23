package com.smilevle.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smilevle.review.model.AttachVO;
import com.smilevle.review.model.PReviewVO;
import com.smilevle.review.model.ReviewPageVO;
import com.smilevle.review.model.ReviewVO;
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
	
	public ReviewVO selectById(Integer reviewNo) {
		return reviewRepository.selectById(reviewNo);
	}
	
	public void insertReview(ReviewVO reviewVO) {
		System.out.println("Service: " + reviewVO);
		reviewRepository.insertReview(reviewVO);
	}
	
	public int getReviewNo( ) {
		return reviewRepository.getReviewNo();
	}
	
	public void insertAttach(AttachVO attachVO) {
		reviewRepository.insertAttach(attachVO);
	}
	
	public void deleteReview(Integer reviewNo) {
		reviewRepository.deleteReview(reviewNo);
	}
	
	public void modifyReview(ReviewVO reviewVO) {
		reviewRepository.modifyReview(reviewVO);
	}
	
	public void modifyAttach(AttachVO attachVO) {
		reviewRepository.modifyAttach(attachVO);
	}
}
