package kr.co.smilevle.review.service;

import java.sql.Connection;
import java.sql.SQLException;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.review.dao.AttachDao;
import kr.co.smilevle.review.model.Attach;

public class SaveAttachService {
	private AttachDao attachDao = new AttachDao();
	
	public void write(SaveAttachRequest saveReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			Attach attach = toAttach(saveReq);
			Attach savedAttach = attachDao.insert(conn, attach);
			if(savedAttach == null) {
				throw new RuntimeException("fail to save attach");
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch(RuntimeException e) {
			throw e;
		} finally {
			JdbcUtil.rollback(conn);
		}
	}

	private Attach toAttach(SaveAttachRequest saveReq) {
		return new Attach(null, saveReq.getReviewNo(), saveReq.getPhotoUrl());
	}
}
