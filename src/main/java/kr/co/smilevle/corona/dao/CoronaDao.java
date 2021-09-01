package kr.co.smilevle.corona.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonDeserializationContext;

import kr.co.smilevle.corona.model.Corona;
import kr.co.smilevle.jdbc.JdbcUtil;

public class CoronaDao {
	public void insert(Connection conn, Corona corona) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("insert into tbl_corona values(?,?,?)")) {
			pstmt.setString(1, corona.getAreaCode());
			pstmt.setString(2, corona.getLocalName());
			pstmt.setInt(3, corona.getCount());
			pstmt.executeUpdate();
		}
	}

	public void update(Connection conn, Corona corona) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("update tbl_corona set count = ? where areacode = ?")) {
			pstmt.setInt(1, corona.getCount());
			pstmt.setString(2, corona.getAreaCode());
			pstmt.executeUpdate();
		}
	}

	public List<Corona> select(Connection conn, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from (select rownum as rnum,"
					+ " areacode, local_name, count from (select * from tbl_corona order by count) "
					+ "where rownum <= ?) where rnum >= 2");
			
			pstmt.setInt(1, size + 2);
			rs = pstmt.executeQuery();
			List<Corona> coronaList = new ArrayList<Corona>();
			
			while (rs.next()) {
				Corona corona = new Corona();
				corona.setAreaCode(rs.getString("areacode"));
				corona.setLocalName(rs.getString("local_name"));
				corona.setCount(rs.getInt("count"));
				coronaList.add(corona);
			}
			return coronaList;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}
