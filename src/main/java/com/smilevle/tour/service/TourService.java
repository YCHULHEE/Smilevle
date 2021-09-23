package com.smilevle.tour.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smilevle.tour.model.TourVO;
import com.smilevle.tour.repository.TourRepository;

@Service
public class TourService {
	
	@Autowired
	private TourRepository tourRepository;

	public List<TourVO> getTourInfoContainer(String areaCode, int size, String contentTypeId) {
		return tourRepository.getTourList(areaCode, size, contentTypeId);
	}

	public TourData getTour(int contentId, boolean increaseReadCount) {
			//컨텐츠 정보를 통해 여행지 정보를 가져온다.
			TourVO tourVO = tourRepository.selectById(contentId);
			if (tourVO == null) {
				throw new TravelDestNotFoundException();
			}
			// 글번호를 통해 글의 내용을 가져온다.
			// increaseReadCount가 true일시 조회수를 증가시킨다.
			if (increaseReadCount) {
				tourRepository.increaseReadCount(contentId);
			}
			String[] imageList = tourVO.getImageList().split(",");
			// 글의 정보와 글의 내용을 아티클데이터로 반환한다.
			return new TourData(tourVO, imageList);
	}
	
	

	public TourPage getTourPage(int pageNum, String areaCode, String smallCategory, String where, String searchWord) {
		int size = 6;
			if(smallCategory == null) {
				smallCategory = "";
			}
			if(searchWord == null) {
				searchWord = "";
			}
			if(areaCode == null) {
				areaCode = "";
			}

			int total = tourRepository.selectCount(areaCode, smallCategory, where, searchWord);
			
			System.out.println("도달하냐?" + total);
			List<TourVO> stayList = tourRepository.selectList(
					areaCode, (pageNum - 1) * size, size, smallCategory, where, searchWord);
			
	
			return new TourPage(total, pageNum, size, stayList);
	}
}
