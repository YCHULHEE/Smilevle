package com.smilevle.util.crawling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.smilevle.tour.model.TourVO;
import com.smilevle.util.model.TourContent;



public class TourWebCrawler {
	
	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
		startCraw();
	}

	private static void startCraw() throws IOException, SAXException, ParserConfigurationException {
		CommonCrawler commonCrawler = new CommonCrawler();
		for (int j = 1; j < 2; j++) {
			String count = String.valueOf(j);
			StringBuilder urlBuilder = new StringBuilder(
					"http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList");
			/* URL */ String serviceKey = "3Snss2wXjZKy30MUZvtZk%2FAZ6pLLu3yOJay%2BU0SbaVesiS1gAFNRhJTaQg92tLeJXx9aBF6mAt2YQ%2BcAq%2F9RRA%3D%3D";
			String serviceKeyDecoded = URLDecoder.decode(serviceKey, "UTF-8");

			urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + serviceKeyDecoded); /* Service Key */
			urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
					+ URLEncoder.encode(serviceKeyDecoded, "UTF-8")); /* 공공데이터포털에서 발급받은 인증키 */
			urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("3", "UTF-8")); /* 현재 페이지 번호 */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("200", "UTF-8")); /* 한 페이지 결과 수 */
			urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "="
					+ URLEncoder.encode("AppTest", "UTF-8")); /* 서비스명=어플명 */
			urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "="
					+ URLEncoder.encode("ETC", "UTF-8")); /* IOS (아이폰), AND (안드로이드),WIN (원도우폰), ETC */
			urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "="
					+ URLEncoder.encode("P", "UTF-8")); /*
														 * (A=제목순, B=조회순, C=수정일순, D=생성일순) , 대표이미지가 반드시 있는 정렬 (O=제목순,
														 * P=조회순, Q=수정일순, R=생성일순)
														 */
			urlBuilder.append(
					"&" + URLEncoder.encode("cat1", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /* 대분류 코드 */
			urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "="
					+ URLEncoder.encode("15", "UTF-8")); /* 관광타입(관광지, 숙박 등) ID */
			urlBuilder.append(
					"&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /* 지역코드 */
			urlBuilder.append("&" + URLEncoder.encode("sigunguCode", "UTF-8") + "="
					+ URLEncoder.encode("", "UTF-8")); /* 시군구코드(areaCode 필수) */
			urlBuilder.append("&" + URLEncoder.encode("cat2", "UTF-8") + "="
					+ URLEncoder.encode("", "UTF-8")); /* 중분류 코드(cat1필수) */
			urlBuilder.append("&" + URLEncoder.encode("cat3", "UTF-8") + "="
					+ URLEncoder.encode("", "UTF-8")); /* 소분류 코드(cat1,cat2필수) */
			urlBuilder.append("&" + URLEncoder.encode("listYN", "UTF-8") + "="
					+ URLEncoder.encode("Y", "UTF-8")); /* 목록 구분 (Y=목록, N=개수) */
			urlBuilder.append("&" + URLEncoder.encode("modifiedtime", "UTF-8") + "="
					+ URLEncoder.encode("", "UTF-8")); /* 콘텐츠 수정일 */

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
			
			
			// 행사 정보용
//			StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival"); /*URL*/
//				/* URL */ String serviceKey = "xviXKlZp2ce8L%2Fai3UQnvIf7D6aHb6iQ%2Fv4OJHBSa2nMr%2BO%2F59xdH8yai46SXl%2Fk9ioVS3PsJGXak7PYfT2NHw%3D%3D";
//			String serviceKeyDecoded = URLDecoder.decode(serviceKey, "UTF-8");
//			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + serviceKeyDecoded); /*Service Key*/
//	        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode(serviceKeyDecoded, "UTF-8")); /*공공데이터포털에서 발급받은 인증키*/
//	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("500", "UTF-8")); /*한 페이지 결과 수*/
//	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
//	        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰),ETC*/
//	        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
//	        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("P", "UTF-8")); /*(A=제목순, B=조회순, C=수정순, D=생성일순) 대표이미지가 반드시 있는 정렬 (O=제목순, P=조회순, Q=수정일순, R=생성일순)*/
//	        urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*목록 구분(Y=목록, N=개수)*/
//	        urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*지역코드*/
//	        urlBuilder.append("&" + URLEncoder.encode("sigunguCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시군구코드(areaCode 필수)*/
//	        urlBuilder.append("&" + URLEncoder.encode("eventStartDate","UTF-8") + "=" + URLEncoder.encode("20210914", "UTF-8")); /*행사 시작일(형식:YYYYMMDD)*/
//	        urlBuilder.append("&" + URLEncoder.encode("eventEndDate","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*행사 종료일(형식:YYYYMMDD)*/
//	        urlBuilder.append("&" + URLEncoder.encode("modifiedtime","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*콘텐츠 수정일*/
//	        URL url = new URL(urlBuilder.toString());
//	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//	        conn.setRequestMethod("GET");
//	        conn.setRequestProperty("Content-type", "application/json");
//	        System.out.println("Response code: " + conn.getResponseCode());
//	        BufferedReader rd;
//	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//	        } else {
//	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//	        }
//	        StringBuilder sb = new StringBuilder();
//	        String line;
//	        while ((line = rd.readLine()) != null) {
//	            sb.append(line);
//	        }
//	        rd.close();
//	        conn.disconnect();

			String parsingUrl = sb.toString();

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = null;
			try {
				dBuilder = dbFactory.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}

			Document doc = null;
			try {
				doc = dBuilder.parse(new InputSource(new StringReader(parsingUrl)));
			} catch (SAXException | IOException e) {
				e.printStackTrace();
			}
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("item");

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					TourVO tour = new TourVO();

					String title = (getTagValue("title", eElement));

//					if (title.contains("모텔")) {
//						continue;
//					}
					if (title.indexOf("[", 2) != -1) {
						title = title.substring(0, title.indexOf("[", 2));
					} 
					if (title.indexOf("{", 2) != -1) {
						title = title.substring(0, title.indexOf("{", 2));
					} 
					if (title.indexOf("(", 2) != -1) {
						title = title.substring(0, title.indexOf("(", 2));
					} 
					tour.setTitle(title);
					tour.setAddress(getTagValue("addr1", eElement));
					if (!getTagValue("tel", eElement).equals("")) {
						tour.setTel(getTagValue("tel", eElement));
					} else {
						tour.setTel("번호 없음");
					}
					
					tour.setTel(getTagValue("tel", eElement));
					// 더블로 넣을시 parsedouble 때문에 속도가 느려짐.
					
					if(getTagValue("mapx", eElement).equals("")) {
						continue;
					}
					tour.setMapX(getTagValue("mapx", eElement));
					tour.setMapY(getTagValue("mapy", eElement));
					if(getTagValue("firstimage", eElement).equals("")) {
						continue;
					}
					tour.setFirstImage(getTagValue("firstimage", eElement));
					if (!getTagValue("contentid", eElement).equals("")) {
						tour.setContentId(Integer.parseInt(getTagValue("contentid", eElement)));
					} else {
						continue;
					}
					Random random = new Random();
					
					random.setSeed(System.currentTimeMillis());
					
					
					if (!getTagValue("readcount", eElement).equals("")) {
						tour.setReadCnt(Integer.parseInt);
					} else {
						tour.setReadCnt(0);
					}
					tour.setAreaCode(getTagValue("areacode", eElement));
					tour.setContentTypeId(getTagValue("contenttypeid", eElement));
					tour.setMiddleCategory(getTagValue("cat2", eElement));
					tour.setSmallCategory(getTagValue("cat3", eElement));					
					
					
					try {
						TourContent tourContent = commonCrawler.selectContentById(tour.getContentId(), tour.getFirstImage());
						
						System.out.print(tourContent.getContent());
						
						tour.setHomePage(tourContent.getHomePage());
						tour.setContent(tourContent.getContent());
						tour.setImageList(tourContent.getImageList());
						CrawlingDao.insertTour(tour);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	private static String getTagValue(String tag, Element eElement) {
		try {
			NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
			Node nValue = (Node) nList.item(0);
			if (nValue == null) {
				return null;
			}
			return nValue.getNodeValue();
		} catch (NullPointerException e) {

		}
		return "";
	}
}
