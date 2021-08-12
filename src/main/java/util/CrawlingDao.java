package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import stay.model.Stay;

public class CrawlingDao {
	private static CrawlingDao crawlingDao = new CrawlingDao();
	public static CrawlingDao getInstance() {
		return crawlingDao;
	}
	
	public static int insertStay(Stay stay) throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "user01";
		String pass = "1234";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		conn = DriverManager.getConnection(url, user, pass);
		
		try {
			pstmt = conn.prepareStatement(
					"insert into stay " +
					"values (stay_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)");					
		pstmt.setString(1, stay.getTitle());
		pstmt.setString(2, stay.getAreacode());
		pstmt.setString(3, stay.getAddress());
		pstmt.setString(4, stay.getFirstImage());
		pstmt.setString(5, stay.getSecondImage());
		pstmt.setString(6, stay.getMapX());
		pstmt.setString(7, stay.getMapY());
		pstmt.setString(8, stay.getTel());
		pstmt.setInt(9, stay.getReadCount());
		
		return pstmt.executeUpdate();
		} finally {
			pstmt.close();
			conn.close();
		}
	}
}
