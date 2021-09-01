package kr.co.smilevle.stay.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.jdbc.JdbcUtil;
import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.stay.dao.StayContentDao;
import kr.co.smilevle.stay.dao.StayDao;
import kr.co.smilevle.stay.model.Stay;
import kr.co.smilevle.stay.model.StayContent;
import kr.co.smilevle.travel.dao.TravelContentDao;
import kr.co.smilevle.travel.model.TravelDest;
import kr.co.smilevle.travel.model.TravelDestContent;
import kr.co.smilevle.travel.service.TravelDestContentNotFoundException;
import kr.co.smilevle.travel.service.TravelDestData;
import kr.co.smilevle.travel.service.TravelDestNotFoundException;


public class StayService {
	private StayDao stayDao = new StayDao();
	private StayContentDao contentDao = new StayContentDao();

	public List<Stay> getStayInfo(String areaCode, int size, String contentTypeId) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			List<Stay> list = stayDao.selectContainer(conn, areaCode, size, contentTypeId);
			conn.commit();
			return list;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public List<Stay> getContainer(String areaCode, int size, String contentTypeId) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			List<Stay> list = stayDao.selectContainer(conn, areaCode, size, contentTypeId);
			conn.commit();
			return list;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public StayData getStay(int contentId, boolean increaseReadCount) throws IOException {
		try (Connection conn = ConnectionProvider.getConnection()){
			//컨텐츠 정보를 통해 여행지 정보를 가져온다.
			Stay stay = stayDao.selectById(conn, contentId);
			if (stay == null) {
				throw new TravelDestNotFoundException();
			}
			// 글번호를 통해 글의 내용을 가져온다.
			StayContent content = contentDao.selectById(conn, contentId);
			if (content == null) {
				throw new TravelDestContentNotFoundException();
			}
			
			// increaseReadCount가 true일시 조회수를 증가시킨다.
			if (increaseReadCount) {
				stayDao.increaseReadCount(conn, contentId);
			}
			
			String[] imageList = content.getImageList().split(",");
			
			// 글의 정보와 글의 내용을 아티클데이터로 반환한다.
			return new StayData(stay, content, imageList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
