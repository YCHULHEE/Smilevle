package kr.co.smilevle.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapInfomation {

	public Map<String, String> getAreaMap() {
		String[] areas = {"지역 전체", "서울", "인천", "대전", "대구", "광주", "부산", "울산", "세종", "경기", "강원", "충북", "충남", "경북", "경남", "전북",
				"전남", "제주" };
		String[] areacodes = {"false", "1", "2", "3", "4", "5", "6", "7", "8", "31", "32", "33", "34", "35", "36", "37", "38",
				"39" };
		Map<String, String> areaMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < areas.length; i++) {
			areaMap.put(areas[i], areacodes[i]);
		}
		return areaMap;
	}

	public Map<String, String> getStayMap() {
		String[] areas = {"숙소 전체", "관광호텔", "수상관광호텔", "전통호텔", "가족호텔", "콘도미니엄", "유스호스텔", "펜션", "여관", "모텔", "민박", "게스트하우스", "홈스테이",
				"서비스드레지던스", "의료관광호텔", "소형호텔", "한옥스테이"};
		String[] areacodes = {"false", "B02010100", "B02010200", "B02010300", "B02010400", "B02010500", "B02010600",
				"B02010700", "B02010800", "B02010900", "B02011000", "B02011100", "B02011200", "B02011300", "B02011400",
				"B02011500", "B02011600" };
		Map<String, String> stayMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < areas.length; i++) {
			stayMap.put(areas[i], areacodes[i]);
		}
		return stayMap;
	}
}
