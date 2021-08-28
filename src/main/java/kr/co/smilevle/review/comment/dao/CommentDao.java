package kr.co.smilevle.review.comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.review.comment.model.Comment;

public class CommentDao {
	
	public Comment insert(Connection conn, Comment comment) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("insert into tbl_review_comment "
						+ "values (review_comment_seq, ?, ?, ?, ?)");
			pstmt.setInt(1, comment.getReviewNo());
			pstmt.setString(2, comment.getContent());
			pstmt.setDate(3, toSqlDate(comment.getRegDate()));
			pstmt.setString(4, comment.getContent());
			int insertedCount = pstmt.executeUpdate();
			
			if (insertedCount > 0) {
				stmt = conn.createStatement();
				 rs = stmt.executeQuery("select max(comment_no) from comment1"); 
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new Comment(newNo,
							comment.getReviewNo(),
							comment.getWriterId(),
							comment.getRegDate(),
							comment.getContent());
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	
	private java.sql.Date toSqlDate(Date date) {
		return new java.sql.Date(date.getTime());
	}

	public static void delete(Connection conn, int commentNumber) {
		// TODO Auto-generated method stub
	}

	public JSONArray select(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from tbl_review_comment where review_no = ? order by comment_no";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			JSONArray result = new JSONArray();
			while(rs.next()) {
				result.add(convertComment(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	
	}

	private JSONObject convertComment(ResultSet rs) throws SQLException {
		JSONObject comment = new JSONObject();
		comment.put("commentNo", rs.getInt("comment_no"));
		comment.put("reviewNo", rs.getInt("review_no"));
		comment.put("writerId", rs.getString("writer_id"));
		comment.put("regDate", rs.getString("regdate"));
		comment.put("content", rs.getString("content"));
		return comment;
	}
	
}