package kr.co.smilevle.util.crawling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.smilevle.stay.model.Stay;
import kr.co.smilevle.travel.model.TravelDest;

public class CrawlingDao {
	private static CrawlingDao crawlingDao = new CrawlingDao();
	public static CrawlingDao getInstance() {
		return crawlingDao;
	}
	
	public static int insertStay(Stay stay) throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@smiledb.cu3f8c2b5bc9.ap-northeast-2.rds.amazonaws.com:9090:smiledb";
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
		pstmt.setString(2, stay.getAreaCode());
		pstmt.setString(3, stay.getAddress());
		pstmt.setString(4, stay.getFirstImage());
		pstmt.setInt(5, stay.getContentId());
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
	
	public static int insertTravelDest(TravelDest travelDest) throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@smiledb.cu3f8c2b5bc9.ap-northeast-2.rds.amazonaws.com:9090:smiledb";
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
					"insert into travel_dest " +
					"values (travel_dest_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");					
		pstmt.setString(1, travelDest.getTitle());
		pstmt.setString(2, travelDest.getAreaCode());
		pstmt.setString(3, travelDest.getAddress());
		pstmt.setString(4, travelDest.getFirstImage());
		pstmt.setInt(5, travelDest.getContentId());
		pstmt.setString(6, travelDest.getMapX());
		pstmt.setString(7, travelDest.getMapY());
		pstmt.setString(8, travelDest.getTel());
		pstmt.setInt(9, travelDest.getReadCount());
		pstmt.setInt(10, travelDest.getContentTypeId());
		
		return pstmt.executeUpdate();
		} finally {
			pstmt.close();
			conn.close();
		}
	}
}
