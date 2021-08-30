package kr.co.smilevle.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.review.model.Attach;

public class AttachDao {
	public Attach insert(Connection conn, Attach attach) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("insert into tbl_review_attach values(photo_seq.nextVal, ?, ?)");
			pstmt.setInt(1, attach.getReviewNo());
			pstmt.setString(2, attach.getPhotoUrl());
			int insertedCount = pstmt.executeUpdate();
			
			if(insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select max(photo_no) from tbl_review_attach");
				
				if(rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Attach(newNum, attach.getReviewNo(), attach.getPhotoUrl());
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
}
