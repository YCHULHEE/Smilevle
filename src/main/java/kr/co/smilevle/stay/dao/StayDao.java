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
import kr.co.smilevle.travel.model.TravelDest;

public class StayDao {
	public List<Stay> selectList(Connection conn, String areaCode, int startRow, int size, String smallCategory, String where) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from (select rownum as rnum, content_id, title, areacode, address, "
				+ "first_image, read_cnt, tel, map_x, map_y, content_type_id, middle_category, small_category "
				+ "from (select * from TBL_TOUR where content_type_id = " + where;
		if(areaCode == null) {
			areaCode = "false";
		}
		if(!areaCode.equals("false")) {
			query += " and areaCode = " + areaCode;
		}
		System.out.println(smallCategory);
		if(smallCategory == null) {
			smallCategory = "false";
		}
		if(!smallCategory.equals("false")) {
			query += " and small_category = '" + smallCategory + "'";
		}
			
		query += " order by read_cnt desc) where rownum <= ?) where rnum >= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow + size);
			pstmt.setInt(2, startRow + 1);
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
				rs.getString("content_type_id"),
						rs.getString("title"),
						rs.getString("areacode"),
						rs.getString("address"),
						rs.getString("first_image"),
						rs.getInt("content_id"),
						rs.getInt("read_cnt"),
						rs.getString("tel"),
						rs.getString("map_x"),
						rs.getString("map_y"), 
						rs.getString("middle_category"),
						rs.getString("small_category"));
	}



	public int selectCount(Connection conn, String areaCode, String smallCategory, String where) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select count(*) from tbl_tour where content_type_id=" + where;
		if(areaCode == null) {
			areaCode = "false";
		}
		if(!areaCode.equals("false")) {
			query += " and areaCode = " + areaCode;
		}
		;
		if(smallCategory == null) {
			smallCategory = "false";
		}
		if(!smallCategory.equals("false")) {
			query += " and small_category = '" + smallCategory + "'";
		}
			
		
		try {
			pstmt = conn.prepareStatement(query);
	
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public List<Stay> selectContainer(Connection conn, String areaCode, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from (select * from tbl_tour order by read_cnt desc) where areacode = ? and RowNum <= ? and content_type_id = 32";
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

	public Stay selectById(Connection conn, int contentId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from tbl_tour where content_id = ?");
			pstmt.setInt(1, contentId);
			rs = pstmt.executeQuery();
			Stay stay = null;
			if (rs.next()) {
				stay = convertStay(rs);
			}
			return stay;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public void increaseReadCount(Connection conn, int content_id) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update tbl_tour set read_cnt = read_cnt + 1 "+
						"where content_id = ?")) {
			pstmt.setInt(1, content_id);
			pstmt.executeUpdate();
		}
		
	}
}

