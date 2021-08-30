package kr.co.smilevle.corona.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.smilevle.corona.model.Corona;


public class CoronaDao {
	public void insert(Connection conn, Corona corona)throws SQLException{
		try(PreparedStatement pstmt=conn.prepareStatement("insert into tbl_corona values(?,?,?)")){
			pstmt.setString(1, corona.getAreaCode());
			pstmt.setString(2, corona.getLocalName());
			pstmt.setInt(3, corona.getCount());
			pstmt.executeUpdate();
		}
	}
	
	public void update(Connection conn, Corona corona)throws SQLException{
		try(PreparedStatement pstmt=conn.prepareStatement("update tbl_corona set count = ? where areacode = ?")){
			pstmt.setInt(1, corona.getCount());
			pstmt.setString(2, corona.getAreaCode());
			pstmt.executeUpdate();
		}
	}

}	
