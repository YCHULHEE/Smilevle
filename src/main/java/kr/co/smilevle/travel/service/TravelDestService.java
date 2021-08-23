package kr.co.smilevle.travel.service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


import kr.co.smilevle.jdbc.connection.ConnectionProvider;
import kr.co.smilevle.travel.dao.TravelContentDao;
import kr.co.smilevle.travel.dao.TravelDao;
import kr.co.smilevle.travel.model.TravelDest;
import kr.co.smilevle.travel.model.TravelDestContent;
import kr.co.smilevle.util.parser.TravelDestParser;

public class TravelDestService {
	private TravelDao travelDao = new TravelDao();
	private TravelContentDao contentDao = new TravelContentDao();
	
	public List<TravelDest> printTourListMain(String size, String areaCode) throws IOException{
		StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"); /*URL*/	String serviceKey = "=ygq6ckNSsXQ8IGk3A5TnTfFiz6osFZwGkzBBfT6fJzmabC0H1Wd67USpVx3Oyfq88cAKcBpgQbvFz0VZQldbVA%3D%3D";
		String serviceKeyDecoded = URLDecoder.decode(serviceKey, "UTF-8");

	 	urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + serviceKeyDecoded); /*Service Key*/
	 	urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
				+ URLEncoder.encode(serviceKeyDecoded, "UTF-8")); /* 공공데이터포털에서 발급받은 인증키 */
	 	urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(size, "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드),WIN (원도우폰), ETC*/
        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("P", "UTF-8")); /*(A=제목순, B=조회순, C=수정일순, D=생성일순) , 대표이미지가 반드시 있는 정렬 (O=제목순, P=조회순, Q=수정일순, R=생성일순)*/
        urlBuilder.append("&"+ URLEncoder.encode("cat1","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*대분류 코드*/
        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("12", "UTF-8")); /*관광타입(관광지, 숙박 등) ID*/
        urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode(areaCode, "UTF-8")); /*지역코드*/
        urlBuilder.append("&" + URLEncoder.encode("sigunguCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시군구코드(areaCode 필수)*/
        urlBuilder.append("&" + URLEncoder.encode("cat2","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*중분류 코드(cat1필수)*/
        urlBuilder.append("&" + URLEncoder.encode("cat3","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*소분류 코드(cat1,cat2필수)*/
        urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*목록 구분 (Y=목록, N=개수)*/
        urlBuilder.append("&" + URLEncoder.encode("modifiedtime","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*콘텐츠 수정일*/
         
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
		
		TravelDestParser tourlistParser = new TravelDestParser();
		
		return tourlistParser.selectMainInfo(parsingUrl);
	}
	
	public TravelDestData getTravelDest(int contentId, boolean increaseReadCount) throws IOException {
		try (Connection conn = ConnectionProvider.getConnection()){
			//컨텐츠 정보를 통해 여행지 정보를 가져온다.
			TravelDest travelDest = travelDao.selectById(conn, contentId);
			if (travelDest == null) {
				throw new TravelDestNotFoundException();
			}
			// 글번호를 통해 글의 내용을 가져온다.
			TravelDestContent content = contentDao.selectContentById(contentId);
			if (content == null) {
				throw new TravelDestContentNotFoundException();
			}
			// increaseReadCount가 true일시 조회수를 증가시킨다.
			if (increaseReadCount) {
				travelDao.increaseReadCount(conn, contentId);
			}
			List<String> imageList = contentDao.selectImageListById(contentId);
			System.out.println( "사이즈는 "+imageList.size());
			
			// 글의 정보와 글의 내용을 아티클데이터로 반환한다.
			return new TravelDestData(travelDest, content, imageList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
