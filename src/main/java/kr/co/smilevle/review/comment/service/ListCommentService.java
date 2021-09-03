package kr.co.smilevle.review.comment.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONArray;

import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.review.comment.dao.CommentDao;
import kr.co.smilevle.review.comment.model.Comment;

public class ListCommentService {
	private CommentDao commentDao = new CommentDao();
	
	public JSONArray getCommentList(int reviewNum) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			JSONArray commentList = commentDao.select(conn, reviewNum);
			return commentList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
