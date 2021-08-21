package kr.co.smilevle.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.review.model.Review;

public class ReviewDao {
	public Review insert(Connection conn, Review review) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("insert into review "
					+ "values(review_seq.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0)");
			pstmt.setString(1, review.getWriter().getId());
			pstmt.setString(2, review.getWriter().getName());
			pstmt.setString(3, review.getTitle());
			pstmt.setInt(4, review.getAreacode());
			pstmt.setString(5, review.getLocationName());
			pstmt.setDouble(6, review.getRate());
			pstmt.setString(7, review.getContent());
			pstmt.setTimestamp(8, toTimestamp(review.getRegDate()));
			pstmt.setTimestamp(9, toTimestamp(review.getModDate()));
			int insertedCount = pstmt.executeUpdate();
			
			if(insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select max(review_no) from review");
				
				if(rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Review(
							newNum, 
							review.getWriter(), 
							review.getTitle(), 
							review.getAreacode(), 
							review.getLocationName(), 
							review.getRate(), 
							review.getContent(), 
							review.getRegDate(), 
							review.getModDate(), 
							0);
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	
}
