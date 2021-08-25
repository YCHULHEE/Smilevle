package kr.co.smilevle.stay.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.stay.dao.StayDao;
import kr.co.smilevle.stay.model.Stay;

public class ListStayService {
	private StayDao stayDao = new StayDao();
	private int size = 9;

	public StayPage getArticlePage(int pageNum, String areaCode) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = stayDao.selectCount(conn, areaCode);
			
			List<Stay> stayList = stayDao.selectList(
					conn, areaCode, (pageNum - 1) * size, size);
			
			
			return new StayPage(total, pageNum, size, stayList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
