package kr.co.smilevle.tour.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.tour.dao.TourContentDao;
import kr.co.smilevle.tour.dao.TourDao;
import kr.co.smilevle.tour.model.Tour;
import kr.co.smilevle.tour.model.TourContent;

public class TourService {
	private TourDao tourDao = new TourDao();
	private TourContentDao contentDao = new TourContentDao();

	public List<Tour> getStayInfo(String areaCode, int size, String contentTypeId) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			List<Tour> list = tourDao.selectContainer(conn, areaCode, size, contentTypeId);
			conn.commit();
			return list;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public List<Tour> getContainer(String areaCode, int size, String contentTypeId) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			List<Tour> list = tourDao.selectContainer(conn, areaCode, size, contentTypeId);
			conn.commit();
			return list;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public TourData getStay(int contentId, boolean increaseReadCount) throws IOException {
		try (Connection conn = ConnectionProvider.getConnection()){
			//컨텐츠 정보를 통해 여행지 정보를 가져온다.
			Tour tour = tourDao.selectById(conn, contentId);
			if (tour == null) {
				throw new TravelDestNotFoundException();
			}
			// 글번호를 통해 글의 내용을 가져온다.
			TourContent content = contentDao.selectById(conn, contentId);
			if (content == null) {
				throw new TravelDestContentNotFoundException();
			}
			
			// increaseReadCount가 true일시 조회수를 증가시킨다.
			if (increaseReadCount) {
				tourDao.increaseReadCount(conn, contentId);
			}
			
			String[] imageList = content.getImageList().split(",");
			
			// 글의 정보와 글의 내용을 아티클데이터로 반환한다.
			return new TourData(tour, content, imageList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
