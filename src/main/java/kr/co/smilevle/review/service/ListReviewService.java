package kr.co.smilevle.review.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.review.dao.ReviewDao;
import kr.co.smilevle.review.model.PReview;

public class ListReviewService {

	private ReviewDao reviewDao = new ReviewDao();
	private int size = 8;
	
	public ReviewPage getReviewPage(int pageNum) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			int total = reviewDao.selectCount(conn);
			List<PReview> content = reviewDao.select(conn, (pageNum - 1) * size, size);
			return new ReviewPage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
