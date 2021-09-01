package kr.co.smilevle.tour.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.tour.model.TourContent;

public class TourContentDao {
	public TourContent selectById(Connection conn, int contentId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from tbl_tour_content where content_id = ?");
			pstmt.setInt(1, contentId);
			rs = pstmt.executeQuery();
			TourContent content = null;
			if (rs.next()) {
				content = convertContent(rs);
			}
			return content;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private TourContent convertContent(ResultSet rs) throws SQLException {
		return new TourContent(
				rs.getInt("content_id"),
				rs.getString("content"),
				rs.getString("homepage"),
				rs.getString("image_list"));
	}
}
