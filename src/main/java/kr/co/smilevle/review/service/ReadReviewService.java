package kr.co.smilevle.review.service;

import java.sql.Connection;
import java.sql.SQLException;

import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.review.dao.ReviewDao;
import kr.co.smilevle.review.model.Review;

public class ReadReviewService {
	private ReviewDao reviewDao = new ReviewDao();
	
	public Review getReview(int reviewNum, boolean increaseReadCount) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			Review review = reviewDao.selectById(conn, reviewNum);
			if(review == null) {
				throw new ReviewNotFoundException();
			}
			if(increaseReadCount) {
				reviewDao.increaseReadCount(conn, reviewNum);
			}
			return review;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
