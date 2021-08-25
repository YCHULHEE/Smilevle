package kr.co.smilevle.review.service;

import java.sql.Connection;
import java.sql.SQLException;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.review.dao.ReviewDao;
import kr.co.smilevle.review.model.Review;

public class DeleteReviewService {
	private ReviewDao reviewDao = new ReviewDao();
	
	public void deleteReview(DeleteReviewRequest delReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Review review = reviewDao.selectById(conn, delReq.getReviewNumber());
			
			if(review == null) {
				throw new ReviewNotFoundException();
			}
			if(!canDelete(delReq.getUserId(), review)) {
				throw new PermissionDeniedException();
			}
			reviewDao.delete(conn, delReq.getReviewNumber());
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

	private boolean canDelete(String userId, Review review) {
		return review.getWriter().getId().equals(userId);
	}
}
