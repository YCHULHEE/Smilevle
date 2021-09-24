package com.smilevle.review.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smilevle.review.model.AttachVO;
import com.smilevle.review.model.PReviewVO;
import com.smilevle.review.model.ReviewPageVO;
import com.smilevle.review.model.ReviewVO;

@Repository
public class ReviewRepository {
	private static final String MAPPER_NAME_SPACE = "smilevle.mapper.reviewMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public List<PReviewVO> getReviewList(ReviewPageVO reviewPageVO) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("start", reviewPageVO.getStart());
		params.put("end", reviewPageVO.getEnd());
		System.out.println(reviewPageVO);
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectReviewList", params);
	}
	
	public int reviewCount() {
		return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "reviewCount");
	}
	
	public ReviewVO selectById(Integer reviewNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("reviewNo", reviewNo);
		return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "selectById", params);
	}
	
	public AttachVO selectAttachById(Integer reviewNo) {
		return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "selectAttachById", reviewNo);
	}
	
	public void insertReview(ReviewVO reviewVO) {
		System.out.println("Repository: " +  reviewVO);
		sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertReview", reviewVO);
	}
	public int getReviewNo() {
		return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "getReviewNo");
	}
	public void insertAttach(AttachVO attachVO) {
		sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertAttach", attachVO);
	}
	
	public void deleteReview(Integer reviewNo) {
		sqlSessionTemplate.delete(MAPPER_NAME_SPACE + "deleteReview", reviewNo);
	}
	
	public void modifyReview(ReviewVO reviewVO) {
		sqlSessionTemplate.update(MAPPER_NAME_SPACE + "modifyReview", reviewVO);
	}
	public void modifyAttach(AttachVO attachVO) {
		sqlSessionTemplate.update(MAPPER_NAME_SPACE + "modifyAttach", attachVO);
	}

}
