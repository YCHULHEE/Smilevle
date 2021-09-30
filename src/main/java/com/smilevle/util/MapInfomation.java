package com.smilevle.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MapInfomation {

	public Map<String, String> getContentMap() {
		String[] areas = { "숙소", "여행지", "볼거리" };
		String[] areacodes = { "32", "12", "15" };
		Map<String, String> contentMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < areas.length; i++) {
			contentMap.put(areacodes[i], areas[i]);
		}
		return contentMap;
	}

	public Map<String, String> getAreaMap() {
		String[] areas = { "지역 전체", "서울", "인천", "대전", "대구", "광주", "부산", "울산", "세종", "경기", "강원", "충북", "충남", "경북", "경남",
				"전북", "전남", "제주" };
		String[] areacodes = { "", "1", "2", "3", "4", "5", "6", "7", "8", "31", "32", "33", "34", "35", "36", "37",
				"38", "39" };
		Map<String, String> areaMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < areas.length; i++) {
			areaMap.put(areacodes[i], areas[i]);
		}
		return areaMap;
	}

	public Map<String, String> getInsertAreaMap() {
		String[] areas = { "지역 전체", "서울", "인천", "대전", "대구", "광주", "부산", "울산", "세종", "경기", "강원", "충북", "충남", "경북", "경남",
				"전북", "전남", "제주" };
		String[] areacodes = { "", "1", "2", "3", "4", "5", "6", "7", "8", "31", "32", "33", "34", "35", "36", "37",
				"38", "39" };
		Map<String, String> areaMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < areas.length; i++) {
			areaMap.put(areas[i], areacodes[i]);
		}
		return areaMap;
	}

	public Map<String, Integer> getTotalPopulation() {
		String[] areas = { "전체", "서울", "부산", "대구", "인천", "광주", "대전", "울산", "세종", "경기", "강원", "충북", "충남", "전북", "전남",
				"경북", "경남", "제주" };
		int[] count = { 51781, 9602, 3344, 2419, 2951, 1488, 1500, 1140, 349, 13405, 1515, 1632, 2204, 1792, 1764, 2655,
				3350, 670 };
		Map<String, Integer> areaMap = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < areas.length; i++) {
			areaMap.put(areas[i], count[i]);
		}
		return areaMap;
	}

	public Map<String, String> getStayMap() {
		String[] stays = { "숙소 전체", "관광호텔", "수상관광호텔", "전통호텔", "가족호텔", "콘도미니엄", "유스호스텔", "펜션", "여관", "모텔", "민박",
				"게스트하우스", "홈스테이", "서비스드레지던스", "의료관광호텔", "소형호텔", "한옥스테이" };
		String[] smallCategorys = { "", "B02010100", "B02010200", "B02010300", "B02010400", "B02010500", "B02010600",
				"B02010700", "B02010800", "B02010900", "B02011000", "B02011100", "B02011200", "B02011300", "B02011400",
				"B02011500", "B02011600" };
		Map<String, String> stayMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < stays.length; i++) {
			stayMap.put(smallCategorys[i], stays[i]);
		}
		return stayMap;
	}

	public Map<String, String> getEventMap() {
		String[] events = { "볼거리 전체", "문화관광축제", "일반축제", "전통공연", "연극", "뮤지컬", "오페라", "전시회", "박람회", "컨벤션", "무용", "클래식음악회",
				"대중콘서트", "영화", "스포츠경기", "기타행사" };
		String[] smallCategorys = { "", "A02070100", "A02070200", "A02080100", "A02080200", "A02080300", "A02080400",
				"A02080500", "A02080600", "A02080700", "A02080800", "A02080900", "A02081000", "A02081100", "A02081200",
				"A02081300" };
		Map<String, String> eventMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < events.length; i++) {
			eventMap.put(smallCategorys[i], events[i]);
		}
		return eventMap;
	}

	public Map<String, String> getTravelDestMap() {
		String[] travelDest = { "여행지 전체", "국립공원", "도립공원", "군립공원", "산", "자연생태관광지", "자연휴양림", "수목원", "폭포", "계곡", "약수터",
				"해안절경", "해수욕장", "섬", "항구/포구", "어촌", "등대", "호수", "강", "동굴", "유원지", "관광단지", "온천/욕장/스파", "이색찜질방", "헬스투어",
				"테마공원", "공원", "유람선/잠수함관광", "농.산.어촌 체험", "전통체험", "산사체험", "이색체험", "관광농원", "이색거리", "다리/대교", "전망대", "분수",
				"동상", "터널", "유명건물" };
		String[] smallCategorys = { "", "A01010100", "A01010200", "A01010300", "A01010400", "A01010500", "A01010600",
				"A01010700", "A01010800", "A01010900", "A01011000", "A01011100", "A01011200", "A01011300", "A01011400",
				"A01011500", "A01011600", "A01011700", "A01011800", "A01011900", "A02020100", "A02020200", "A02020300",
				"A02020400", "A02020500", "A02020600", "A02020700", "A02020800", "A02030100", "A02030200", "A02030300",
				"A02030400", "A02030500", "A02030600", "A02050100", "A02050200", "A02050300", "A02050400", "A02050500",
				"A02050600" };
		Map<String, String> travelDestMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < travelDest.length; i++) {
			travelDestMap.put(smallCategorys[i], travelDest[i]);
		}
		return travelDestMap;
	}
}
