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
						+ "values (review_comment_seq.nextval, ?, ?, ?, ?)");
			pstmt.setInt(1, comment.getReviewNo());
			pstmt.setString(2, comment.getWriterId());
			pstmt.setTimestamp(3, toTimestamp(comment.getRegDate()));
			pstmt.setString(4, comment.getContent());
			int insertedCount = pstmt.executeUpdate();
			
			if (insertedCount > 0) {
				stmt = conn.createStatement();
				 rs = stmt.executeQuery("select max(comment_no) from tbl_review_comment"); 
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
	
	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
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
		String date = rs.getString("regdate");
		String[] dateSpl = date.split("\\.");
		comment.put("regDate", dateSpl[0]);
		comment.put("content", rs.getString("content"));
		return comment;
	}
	
	public Comment selectById(Connection conn, int commentNumber) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from tbl_review_comment where comment_no = ?");
			pstmt.setInt(1, commentNumber);
			rs = pstmt.executeQuery();
			Comment comment = null;
			if(rs.next()) {
				comment = new Comment(rs.getInt("comment_no"), 
									  rs.getInt("review_no"), 
									  rs.getString("writer_id"), 
									  toDate(rs.getTimestamp("regdate")), 
									  rs.getString("content"));
			}
			return comment;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}

	public int delete(Connection conn, int commentNumber) throws SQLException {
		try(PreparedStatement pstmt = conn.prepareStatement("delete from tbl_review_comment where comment_no = ?")) {
			pstmt.setInt(1, commentNumber);
			return pstmt.executeUpdate();
		}
	}
}
