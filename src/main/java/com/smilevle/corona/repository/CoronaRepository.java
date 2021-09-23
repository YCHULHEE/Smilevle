package com.smilevle.corona.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smilevle.corona.model.CoronaVO;

@Repository
public class CoronaRepository {
	private static final String MAPPER_NAME_SPACE="smilevle.mapper.coronaMapper.";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(CoronaVO coronaVO) {
		//areaCode},#{localName},#{count
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", coronaVO.getAreaCode());
		params.put("localName", coronaVO.getLocalName());
		params.put("count", coronaVO.getCount());
		sqlSessionTemplate.insert(MAPPER_NAME_SPACE +"insert", params);
	}
	
	public void update(CoronaVO coronaVO) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("count", coronaVO.getCount());
		params.put("localName", coronaVO.getLocalName());
		
		sqlSessionTemplate.update(MAPPER_NAME_SPACE +"update", params);
	}
	//
	
	public List<CoronaVO> selectList(int size) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("size", size);
		
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectList", params);
	}
}
