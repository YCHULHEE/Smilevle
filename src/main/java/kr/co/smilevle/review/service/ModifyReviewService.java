package kr.co.smilevle.review.service;

import java.sql.Connection;
import java.sql.SQLException;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.review.dao.ReviewDao;
import kr.co.smilevle.review.model.Review;

public class ModifyReviewService {
	private ReviewDao reviewDao = new ReviewDao();
	
	public void modify(ModifyRequest modReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Review review = reviewDao.selectById(conn, modReq.getReviewNumber());
			if(review == null) {
				throw new ReviewNotFoundException();
			}
			if(!canModify(modReq.getUserId(), review)) {
				throw new PermissionDeniedException();
			}
			reviewDao.update(conn, modReq.getReviewNumber(), modReq.getTitle(), modReq.getAreacode(), modReq.getLocationName(), modReq.getRate(), modReq.getContent());
			conn.commit();
		} catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch(PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private boolean canModify(String userId, Review review) {
		return review.getWriter().getId().equals(userId);
	}
}
