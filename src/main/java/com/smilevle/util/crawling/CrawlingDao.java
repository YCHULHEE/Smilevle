package com.smilevle.util.crawling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.smilevle.tour.model.TourVO;
import com.smilevle.util.model.TourContent;




public class CrawlingDao {
	private static CrawlingDao crawlingDao = new CrawlingDao();

	public static CrawlingDao getInstance() {
		return crawlingDao;
	}

	public static int insertTour(TourVO stay) throws SQLException {
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
			pstmt = conn.prepareStatement("insert into TBL_TOUR " + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, stay.getContentId());
			pstmt.setString(2, stay.getTitle());
			pstmt.setString(3, stay.getAreaCode());
			pstmt.setString(4, stay.getAddress());
			pstmt.setString(5, stay.getFirstImage());
			pstmt.setString(6, stay.getMapX());
			pstmt.setString(7, stay.getMapY());
			pstmt.setString(8, stay.getTel());
			pstmt.setInt(9, stay.getReadCnt());
			pstmt.setString(10, stay.getContentTypeId());
			pstmt.setString(11, stay.getMiddleCategory());
			pstmt.setString(12, stay.getSmallCategory());
			pstmt.setString(13, stay.getHomePage());
			pstmt.setString(14, stay.getImageList());
			pstmt.setString(15, stay.getContent());

			return pstmt.executeUpdate();
		} finally {
			pstmt.close();
			conn.close();
		}
	}

	public static int insertContent(TourContent tourContent) throws SQLException {
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
					"insert into TBL_TOUR_CONTENT " + "values (?, ?, ?, ?)");
			pstmt.setInt(1, tourContent.getContentId());
			pstmt.setString(2, tourContent.getContent());
			pstmt.setString(3, tourContent.getHomePage());
			pstmt.setString(4, tourContent.getImageList());
			

			return pstmt.executeUpdate();
		} finally {
			pstmt.close();
			conn.close();
		}
	}
}
