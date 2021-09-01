package kr.co.smilevle.tour.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.tour.dao.TourDao;
import kr.co.smilevle.tour.model.Tour;

public class ListTourService {
	private TourDao tourDao = new TourDao();
	private int size = 6;

	public TourPage getArticlePage(int pageNum, String areaCode, String smallCategory, String where, String searchWord) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = tourDao.selectCount(conn, areaCode, smallCategory, where, searchWord);
			System.out.println(total);
			List<Tour> stayList = tourDao.selectList(
					conn, areaCode, (pageNum - 1) * size, size, smallCategory, where, searchWord);
			
			
			return new TourPage(total, pageNum, size, stayList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
