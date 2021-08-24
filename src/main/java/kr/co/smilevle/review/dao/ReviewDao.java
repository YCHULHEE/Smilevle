package kr.co.smilevle.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.review.model.Review;
import kr.co.smilevle.review.model.Writer;

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
			pstmt.setString(4, review.getAreacode());
			pstmt.setString(5, review.getLocationName());
			pstmt.setString(6, review.getRate());
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
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from review");
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
	}
	
	public List<Review> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from (select rownum as rnum, review_no, writer_id, writer_name, title, areacode, location_name, rate, content, regdate, moddate, read_cnt "
				+ "from (select * from review order by review_no desc) where rownum <= ?) where rnum >= ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow + size);
			pstmt.setInt(2, startRow + 1);
			rs = pstmt.executeQuery();
			List<Review> result = new ArrayList<>();
			while(rs.next()) {
				result.add(convertReview(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Review convertReview(ResultSet rs) throws SQLException {
		return new Review(rs.getInt("review_no"), 
						  new Writer(rs.getString("writer_id"), rs.getString("writer_name")),
						  rs.getString("title"),
						  rs.getString("areacode"),
						  rs.getString("location_name"),
						  rs.getString("rate"),
						  rs.getString("content"),
						  toDate(rs.getTimestamp("regdate")),
						  toDate(rs.getTimestamp("moddate")),
						  rs.getInt("read_cnt"));
						  
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
	public Review selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from review where review_no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Review review = null;
			if(rs.next()) {
				review = convertReview(rs);
			}
			return review;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void increaseReadCount(Connection conn, int no) throws SQLException {
		try(PreparedStatement pstmt = conn.prepareStatement("update review set read_cnt = read_cnt + 1 where review_no = ?")) {
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
	
}
