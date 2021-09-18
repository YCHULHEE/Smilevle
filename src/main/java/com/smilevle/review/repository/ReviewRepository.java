package com.smilevle.review.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smilevle.review.model.PReviewVO;

@Repository
public class ReviewRepository {
	private static final String MAPPER_NAME_SPACE = "smilevle.mapper.reviewMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public List<PReviewVO> getReviewList() {
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectReviewList");
	}
}
