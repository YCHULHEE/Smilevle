package kr.co.smilevle.travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.travel.model.TravelDest;

public class TravelDao {

	public TravelDest selectById(Connection conn, int contentId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from travel_dest where content_id = ?");
			pstmt.setInt(1, contentId);
			rs = pstmt.executeQuery();
			TravelDest travelDest = null;
			if (rs.next()) {
				travelDest = convertTravelDest(rs);
			}
			return travelDest;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private TravelDest convertTravelDest(ResultSet rs) throws SQLException {
		return new TravelDest(rs.getString("travel_dest_id"), 
				rs.getInt("content_id"),
				rs.getString("title"),
				rs.getString("areacode"),
				rs.getString("address"),
				rs.getString("first_image"),
				rs.getInt("read_cnt"), 
				rs.getString("tel"),
				rs.getString("map_x"),
				rs.getString("map_y"), 
				rs.getInt("content_Type_Id"));
	}
	
	public void increaseReadCount(Connection conn, int content_id) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update travel_dest set read_cnt = read_cnt + 1 "+
						"where content_id = ?")) {
			pstmt.setInt(1, content_id);
			pstmt.executeUpdate();
		}
	}
}
