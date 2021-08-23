package kr.co.smilevle.login.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.login.dao.MemberDao;
import kr.co.smilevle.login.member.Member;



public class JoinService {
private MemberDao memberDao=new MemberDao();
	
	public void join(JoinRequest joinReq) {
		Connection conn=null;
		try {
			conn=ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member=memberDao.selectById(conn, joinReq.getId());
			if(member!=null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			memberDao.insert(conn,new Member(
					joinReq.getId(),
					joinReq.getName(),
					joinReq.getPassword(),
					new Date(),
					joinReq.getEmail(),
					joinReq.getGender(),
					joinReq.getBirthday(),
					joinReq.getPhonenum())
					);
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
			
		}finally {
			JdbcUtil.close(conn);
		}
	}

}
