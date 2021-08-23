package kr.co.smilevle.event.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.co.smilevle.event.model.Event;
import kr.co.smilevle.util.parser.EventParser;


public class EventService {
	public List<Event> printEventMain(String size, String areaCode) throws IOException {
		SimpleDateFormat format = new SimpleDateFormat ( "yyyyMMdd");
		Date time = new Date();
		String nowTime = format.format(time);
		
		StringBuilder urlBuilder = new StringBuilder(
				"http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival");
		/* URL */ String serviceKey = "=ygq6ckNSsXQ8IGk3A5TnTfFiz6osFZwGkzBBfT6fJzmabC0H1Wd67USpVx3Oyfq88cAKcBpgQbvFz0VZQldbVA%3D%3D";
		String serviceKeyDecoded = URLDecoder.decode(serviceKey, "UTF-8");

		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + serviceKeyDecoded); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
				+ URLEncoder.encode(serviceKeyDecoded, "UTF-8")); /* 공공데이터포털에서 발급받은 인증키 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode(size, "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append(
				"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 현재 페이지 번호 */
		urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "="
				+ URLEncoder.encode("ETC", "UTF-8")); /* IOS (아이폰), AND (안드로이드), WIN (원도우폰),ETC */
		urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "="
				+ URLEncoder.encode("AppTest", "UTF-8")); /* 서비스명=어플명 */
		urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=" + URLEncoder.encode("P",
				"UTF-8")); /*
							 * (A=제목순, B=조회순, C=수정순, D=생성일순) 대표이미지가 반드시 있는 정렬 (O=제목순, P=조회순, Q=수정일순, R=생성일순)
							 */
		urlBuilder.append("&" + URLEncoder.encode("listYN", "UTF-8") + "="
				+ URLEncoder.encode("Y", "UTF-8")); /* 목록 구분(Y=목록, N=개수) */
		urlBuilder
				.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + URLEncoder.encode(areaCode, "UTF-8")); /* 지역코드 */
		urlBuilder.append("&" + URLEncoder.encode("sigunguCode", "UTF-8") + "="
				+ URLEncoder.encode("", "UTF-8")); /* 시군구코드(areaCode 필수) */
		urlBuilder.append("&" + URLEncoder.encode("eventStartDate", "UTF-8") + "="
				+ URLEncoder.encode(nowTime, "UTF-8")); /* 행사 시작일(형식:YYYYMMDD) */
		urlBuilder.append("&" + URLEncoder.encode("eventEndDate", "UTF-8") + "="
				+ URLEncoder.encode("20211223", "UTF-8")); /* 행사 종료일(형식:YYYYMMDD) */
		urlBuilder.append(
				"&" + URLEncoder.encode("modifiedtime", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /* 콘텐츠 수정일 */
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();

		String parsingUrl = sb.toString();

		EventParser eventParser = new EventParser();

		return eventParser.selectMainInfo(parsingUrl);
	}
}
