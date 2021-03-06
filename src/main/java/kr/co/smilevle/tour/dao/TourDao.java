package kr.co.smilevle.tour.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.tour.model.Tour;

public class TourDao {
	public List<Tour> selectList(Connection conn, String areaCode, int startRow, 
			int size, String smallCategory, String where, String searchWord) throws SQLException {
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
		
		if(searchWord == null) {
			searchWord = "false";
		}
		if(!(searchWord.equals("false") || searchWord.equals(""))) {
			query += " and title LIKE '%" + searchWord + "%'";
		}
		
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
			List<Tour> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertStay(rs));
			}
			
			
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Tour convertStay(ResultSet rs) throws SQLException {
		return new Tour(
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



	public int selectCount(Connection conn, String areaCode, String smallCategory, String where, String searchWord) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select count(*) from tbl_tour where content_type_id=" + where;
		if(areaCode == null) {
			areaCode = "false";
		}
		if(!areaCode.equals("false")) {
			query += " and areaCode = " + areaCode;
		}
		if(searchWord == null) {
			searchWord = "false";
		}
		
		if(!(searchWord.equals("false") || searchWord.equals(""))) {
			query += " and title LIKE '%" + searchWord + "%'";
		}
		
		if(smallCategory == null) {
			smallCategory = "false";
		}
		if(!smallCategory.equals("false")) {
			query += " and small_category = '" + smallCategory + "'";
		}
			
		System.out.println(query);
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
	
	public List<Tour> selectContainer(Connection conn, String areaCode, int size, String contentTypeId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from (select * from tbl_tour order by read_cnt desc) where RowNum <= ? and content_type_id = ?";
		if(!areaCode.equals("false")) {
			query += " and areacode = " + areaCode;
		}
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, size);
			pstmt.setString(2, contentTypeId);
			rs = pstmt.executeQuery();
			List<Tour> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertStay(rs));
			}
			
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public Tour selectById(Connection conn, int contentId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from tbl_tour where content_id = ?");
			pstmt.setInt(1, contentId);
			rs = pstmt.executeQuery();
			Tour tour = null;
			if (rs.next()) {
				tour = convertStay(rs);
			}
			return tour;
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

