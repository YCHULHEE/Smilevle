package kr.co.smilevle.stay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.stay.model.Stay;
//Connection conn, int areacode, int num
public class StayDao {
	public List<Stay> select() throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = ConnectionProvider.getConnection();
		try {
			pstmt = conn.prepareStatement("select * from (select title, address, firstimage, readcount, areacode from stay order by readcount desc) where RowNum <= 7");
			

			rs = pstmt.executeQuery();
			List<Stay> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertStay(rs));
			}
			for(int i = 0; i < 7; i++) {
				System.out.println(result.get(i).getTitle());
			}
			
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	

	private Stay convertStay(ResultSet rs) throws SQLException {
		return new Stay(
						rs.getString("title"),
						rs.getString("areacode"),
						rs.getString("address"),
						rs.getString("firstimage"),
						rs.getInt("readcount"));
	}
}

