package kr.co.smilevle.stay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.stay.model.Stay;

public class StayDao {
	public List<Stay> selectList(Connection conn, String areaCode, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "select * from (select rownum as rnum, stay_id, title, areacode, address, first_image, content_id, read_cnt, tel, map_x, may_y "
				+ "from (select * from stay where areacode = ? order by read_cnt desc) where rownum <= ?) where rnum >= ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, areaCode);
			pstmt.setInt(2, startRow + size);
			pstmt.setInt(3, startRow + 1);
			rs = pstmt.executeQuery();
			List<Stay> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertStay(rs));
			}
			
			
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Stay convertStay(ResultSet rs) throws SQLException {
		return new Stay(
						rs.getString("stay_id"),
						rs.getString("title"),
						rs.getString("areacode"),
						rs.getString("address"),
						rs.getString("first_image"),
						rs.getInt("content_id"),
						rs.getInt("read_cnt"),
						rs.getString("tel"),
						rs.getString("map_x"),
						rs.getString("map_y"));
	}



	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from stay");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public List<Stay> selectContainer(Connection conn, String areaCode, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from (select * from stay order by read_cnt desc) where areacode = ? and RowNum <= ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, areaCode);
			pstmt.setInt(2, size);

			rs = pstmt.executeQuery();
			List<Stay> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertStay(rs));
			}
			
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}

