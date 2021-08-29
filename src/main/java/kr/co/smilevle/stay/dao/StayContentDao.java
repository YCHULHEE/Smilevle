package kr.co.smilevle.stay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.stay.model.StayContent;

public class StayContentDao {
	public StayContent selectById(Connection conn, int contentId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from tbl_tour_content where content_id = ?");
			pstmt.setInt(1, contentId);
			rs = pstmt.executeQuery();
			StayContent content = null;
			if (rs.next()) {
				content = convertContent(rs);
			}
			return content;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private StayContent convertContent(ResultSet rs) throws SQLException {
		return new StayContent(
				rs.getInt("content_id"),
				rs.getString("content"),
				rs.getString("homepage"),
				rs.getString("image_list"));
	}
}
