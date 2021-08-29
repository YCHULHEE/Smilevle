package kr.co.smilevle.review.comment.service;

import java.sql.Connection;
import java.sql.SQLException;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.review.comment.dao.CommentDao;
import kr.co.smilevle.review.comment.model.Comment;
import kr.co.smilevle.review.service.PermissionDeniedException;

public class DeleteCommentService {
	private CommentDao commentDao = new CommentDao();
	
	public void deleteComment(DeleteCommentRequest delReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			Comment comment = commentDao.selectById(conn, delReq.getCommentNumber());
			if(comment == null) {
				throw new CommentNotFoundException();
			}
			if(!canDelete(delReq.getUserId(), comment)) {
				throw new PermissionDeniedException();
			}
			commentDao.delete(conn, delReq.getCommentNumber());
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch(PermissionDeniedException e) {
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private boolean canDelete(String userId, Comment comment) {
		return comment.getWriterId().equals(userId);
	}
}
