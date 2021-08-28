package kr.co.smilevle.stay.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.stay.dao.StayDao;
import kr.co.smilevle.stay.model.Stay;

public class ListStayService {
	private StayDao stayDao = new StayDao();
	private int size = 6;

	public StayPage getArticlePage(int pageNum, String areaCode, String smallCategory, String where) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = stayDao.selectCount(conn, areaCode, smallCategory, where);
			System.out.println(total);
			List<Stay> stayList = stayDao.selectList(
					conn, areaCode, (pageNum - 1) * size, size, smallCategory, where);
			
			
			return new StayPage(total, pageNum, size, stayList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
