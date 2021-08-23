package kr.co.smilevle.login.service;

import java.sql.Connection;
import java.sql.SQLException;

import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.login.dao.MemberDao;
import kr.co.smilevle.login.member.Member;


public class LoginService {
	
	private MemberDao memberDao=new MemberDao();
	
	public User login(String id, String password) {
		try(Connection conn=ConnectionProvider.getConnection()){
			Member member=memberDao.selectById(conn, id);
			if(member==null) {
				throw new LoginFailException();
			}
			if(!member.matchPassword(password)) {
				throw new LoginFailException();
			}
			return new User(member.getId(), member.getName(),member.getEmail(),member.getGender(),
					member.getBirthday(),member.getPhonenum());
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
