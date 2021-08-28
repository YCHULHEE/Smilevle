package kr.co.smilevle.review.comment.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.review.comment.dao.CommentDao;
import kr.co.smilevle.review.comment.model.Comment;

public class WriteCommentService {
	private CommentDao commentDao = new CommentDao();
	
	public void writeComment(WriteCommentRequest writeReq) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			Comment comment = toComment(writeReq);
			Comment savedComment = commentDao.insert(conn, comment);
			if(savedComment == null) {
				throw new RuntimeException("fail to insert comment");
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch(RuntimeException e) {	
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}
	

	private Comment toComment(WriteCommentRequest writeReq) {
		Date now = new Date();
		return new Comment(null, 
						   writeReq.getReviewNumber(), 
						   writeReq.getWriterId(), 
						   now, 
						   writeReq.getContent());
	}
}
