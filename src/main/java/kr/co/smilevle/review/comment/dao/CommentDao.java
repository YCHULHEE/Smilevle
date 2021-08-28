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

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.review.comment.model.Comment;

public class CommentDao {
	
//	public Comment insert(Connection conn, Comment comment) throws SQLException {
//		PreparedStatement pstmt = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		
//		try {
//			pstmt = conn.prepareStatement("insert into comment1 "
//						+ "values (num_seq.nextval,?,?,?)");
//			pstmt.setString(1, comment.getWriter_id()); //long으로 가지고 오는거 맞음? 이거는 articlecontent 참고
//			pstmt.setTimestamp(2, toTimestamp(comment.getRegDate()));  //writer빼고 id는 이름 바꾸기
//			pstmt.setString(3, comment.getContent());
//			int insertedCount = pstmt.executeUpdate();  // 1-INSERT, DELETE, UPDATE성공, 0-행의 수 아무 리턴이 없음
//			
//			if (insertedCount > 0) {
//				stmt = conn.createStatement();
//				 rs = stmt.executeQuery("select max(comment_no) from comment1"); 
//				if (rs.next()) {
//					Integer newNo = rs.getInt(1);
//					return new Comment(newNo,         //no해야할까 num해야할까
//							comment.getWriter_id(), //둘중 하나
//							comment.getRegDate(),
//							comment.getContent());
//				}
//			}
//			return null;
//		} finally {
//			JdbcUtil.close(rs);
//			JdbcUtil.close(stmt);
//			JdbcUtil.close(pstmt);
//		}
//	}
	
	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	public static void delete(Connection conn, int commentNumber) {
		// TODO Auto-generated method stub
	}

	public List<Comment> select(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from tbl_review_comment where review_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			List<Comment> result = new ArrayList<>();
			while(rs.next()) {
				result.add(convertComment(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	
	}

	private Comment convertComment(ResultSet rs) throws SQLException {
		return new Comment(rs.getInt("comment_no"), 
						   rs.getInt("review_no"), 
						   rs.getString("writer_id"), 
						   toDate(rs.getTimestamp("regdate")), 
						   rs.getString("content"));
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
}
