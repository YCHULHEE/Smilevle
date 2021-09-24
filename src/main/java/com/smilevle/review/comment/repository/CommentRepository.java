package com.smilevle.review.comment.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smilevle.review.comment.model.CommentVO;

@Repository
public class CommentRepository {
	private static final String MAPPER_NAME_SPACE = "smilevle.mapper.commentMapper.";
			
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<CommentVO> getCommentList(Integer reviewNo) {
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "commentList", reviewNo);
	}
}
