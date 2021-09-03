package kr.co.smilevle.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AreacodeConverter {
	public static String[] rates = {"1.0", "2.0", "3.0", "4.0", "5.0"};
	
	public static Map<String, String> getAreaMap() {
		String[] areas = {"서울", "인천", "대전", "대구", "광주", 
				"부산", "울산", "세종", "경기", "강원", "충북",
				"충남", "경북", "경남", "전북", "전남", "제주"};
		String[] areacodes = {"1", "2", "3", "4", "5", "6", "7", "8",
				"31", "32", "33", "34", "35", "36", "37", "38", "39"};
		Map<String, String> areaMap = new LinkedHashMap<String, String>();
		for(int i = 0; i < areas.length; i++) {
			areaMap.put(areas[i], areacodes[i]);
		}
		return areaMap;
	}	
}
