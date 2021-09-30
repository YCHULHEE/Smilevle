package com.smilevle.tour.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smilevle.tour.model.TotalCountVO;
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
		return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE +"selectById", params);
	}
	
	public void increaseReadCount(int contentId) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("contentId", contentId);
			sqlSessionTemplate.update(MAPPER_NAME_SPACE +"increaseReadCount", params);
	}

	public int selectCount(String areaCode, String smallCategory, String where, String searchWord) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", areaCode);
		params.put("smallCategory", smallCategory);
		params.put("where", where);
		System.out.println(searchWord + "서치워드");
		params.put("searchWord", searchWord);
		return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE +"selectCount", params);
	}
	
	public List<TourVO> selectList(String areaCode, int pageNum, int size, String smallCategory, String where, String searchWord) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("startRow", pageNum + 1);
		params.put("endRow", pageNum + size);
		params.put("areaCode", areaCode);
		params.put("smallCategory", smallCategory);
		params.put("where", where);
		params.put("searchWord", searchWord);
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE +"selectList", params);
	}

	public void register(TourVO vo) {
		sqlSessionTemplate.insert(MAPPER_NAME_SPACE +"register", vo);
	}

	public void modify(TourVO vo) {
		sqlSessionTemplate.update(MAPPER_NAME_SPACE +"modify", vo);
	}
	
	public void delete(int contentId) {
		sqlSessionTemplate.delete(MAPPER_NAME_SPACE +"delete", contentId);
	}
	public List<TotalCountVO> getTotalCount() {
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "getTotalCount");
	}
	
	public List<TotalCountVO> getSmallCategoryCount(String localName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("localName",localName);
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "getSmallCategoryCount", params);
	}
	
}
