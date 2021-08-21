package kr.co.smilevle.review.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.review.dao.ReviewDao;
import kr.co.smilevle.review.model.Review;

public class WriteReviewService {
	
	private ReviewDao reviewDao = new ReviewDao();
	
	public Integer write(WriteReviewRequest writeReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			Review review = toReview(writeReq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Review toReview(WriteReviewRequest writeReq) {
		Date now = new Date();
		return new Review(null, writeReq.getWriter(), writeReq.getTitle(), writeReq.getAreacode(), writeReq.getLocationName(), writeReq.getRate(), writeReq.getContent(), now, now, 0);
	}
}
