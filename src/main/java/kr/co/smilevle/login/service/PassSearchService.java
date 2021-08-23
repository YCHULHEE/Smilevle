package kr.co.smilevle.login.service;

import java.sql.Connection;
import java.sql.SQLException;

import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.login.dao.MemberDao;
import kr.co.smilevle.login.member.Member;

public class PassSearchService {
	
	private MemberDao memberDao=new MemberDao();
	public Member search(String id, String email) {
		try(Connection conn=ConnectionProvider.getConnection()){
			Member member=memberDao.selectById(conn, id);
			if(member==null) {
				throw new SearchFailException();
			}
			if(!member.matchEmail(email)) {
				throw new SearchFailException();
			}
			return new Member(member.getId(), member.getName(),member.getPassword(),member.getRegDate(),member.getEmail(),member.getGender(),
					member.getBirthday(),member.getPhonenum());
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}