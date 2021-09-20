package com.smilevle.review.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	public void insertReview(ReviewVO reviewVO) {
		System.out.println("Repository: " +  reviewVO);
		sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertReview", reviewVO);
	}

}
