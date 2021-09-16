package com.smilevle.tour.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smilevle.tour.model.TourVO;

@Repository
public class TourRepository {
	private static final String MAPPER_NAME_SPACE="smilevle.mapper.tourMapper.";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<TourVO> getTourList(String areaCode, int size, String contentTypeId) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("size", size);
		params.put("contentTypeId", contentTypeId);
		params.put("areaCode", areaCode);
		
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE +"getTourList", params);
	}
	
	public TourVO selectById(int contentId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("contentId", contentId);
		return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE +"selectTourContainer", params);
	}
	
	public void increaseReadCount(int contentId) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("contentId", contentId);
			sqlSessionTemplate.update(MAPPER_NAME_SPACE +"increaseReadCount", params);
	}
}
