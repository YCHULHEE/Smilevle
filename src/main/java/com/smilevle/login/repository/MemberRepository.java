package com.smilevle.login.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smilevle.login.model.MemberVO;


@Repository
public class MemberRepository {
	private static final String MAPPER_NAME_SPACE="smilevle.mapper.MemberMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberVO SelectById(String memberId) {
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("memberId", memberId);
		return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE+"SelectById",params);				
	}
	
	
	
	public void insertMember(MemberVO memberVO) {
		sqlSessionTemplate.insert(MAPPER_NAME_SPACE+"insertMember",memberVO);
	}
	
//	public List<MemberVO> getTourList(String memberId, String name, String password,String email,String gender
//			,String birthday,String phonenum) {
//		Map<String, Object> params = new HashMap<String, Object>();
//		
//		params.put("memberId", memberId);
//		params.put("name", name);
//		params.put("password", password);
//		params.put("email", email);
//		params.put("gender", gender);
//		params.put("birthday", birthday);
//		params.put("phonenum", phonenum);
//		
//		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE +"insertUserInfo", params);
//	}
	
	
	
}
