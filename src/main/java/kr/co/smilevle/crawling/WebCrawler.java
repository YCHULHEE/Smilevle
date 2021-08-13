package kr.co.smilevle.crawling;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import kr.co.smilevle.stay.model.Stay;


public class WebCrawler {
	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
		StringBuilder urlBuilder = new StringBuilder(
				"http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchStay"); /* URL */
		String serviceKey = "=ygq6ckNSsXQ8IGk3A5TnTfFiz6osFZwGkzBBfT6fJzmabC0H1Wd67USpVx3Oyfq88cAKcBpgQbvFz0VZQldbVA%3D%3D";
		String serviceKeyDecoded = URLDecoder.decode(serviceKey, "UTF-8");
		String parsingUrl;

		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + serviceKeyDecoded); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
				+ URLEncoder.encode(serviceKeyDecoded, "UTF-8")); /* 공공데이터포털에서 발급받은 인증키 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("100", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append(
				"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 현재 페이지 번호 */
		urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "="
				+ URLEncoder.encode("ETC", "UTF-8")); /* IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC */
		urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "="
				+ URLEncoder.encode("AppTest", "UTF-8")); /* 서비스명=어플명 */
		urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=" + URLEncoder.encode("O",
				"UTF-8")); /* (A=제목순,B=조회순,C=수정순,D=생성일순) 대표이미지가 반드시 있는 정렬 (O=제목순, P=조회순, Q=수정일순, R=생성일순) */
		urlBuilder.append("&" + URLEncoder.encode("listYN", "UTF-8") + "="
				+ URLEncoder.encode("Y", "UTF-8")); /* 목록구분(Y=목록,N=개수) */
		urlBuilder
				.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /* 지역코드 */
		urlBuilder.append("&" + URLEncoder.encode("sigunguCode", "UTF-8") + "="
				+ URLEncoder.encode("", "UTF-8")); /* 시군구코드(areaCode 필수) */
		urlBuilder.append("&" + URLEncoder.encode("hanOk", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /* 한옥 여부 */
		urlBuilder.append(
				"&" + URLEncoder.encode("benikia", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /* 베니키아 여부 */
		urlBuilder.append(
				"&" + URLEncoder.encode("goodStay", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /* 굿스테이 여부 */
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
		System.out.println(sb.toString());

		// 파싱 시작.
		parsingUrl = sb.toString();
		System.out.println(parsingUrl);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		// 이 메소드 DocumentBuilder.parse(String)는 URI를 가져 와서 열려고 시도합니다.
		// 컨텐츠를 직접 제공하려면 컨텐츠를 InputStream또는 Reader로 지정해야합니다 .
		Document doc = dBuilder.parse(new InputSource(new StringReader(parsingUrl)));
		doc.getDocumentElement().normalize();

		// doc.getDocumentElement().getNodeName() => 최상위 노드 확인
//      System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

		// 대장 노드
		NodeList nList = doc.getElementsByTagName("item");
//      System.out.println("파싱할 리스트 수 : " + nList.getLength());

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				Stay stay = new Stay();

				System.out.println("=================================");
				System.out.println(getTagValue("title", eElement));// 사업장명
				System.out.println(getTagValue("addr1", eElement));// 자료생성년월
				System.out.println(getTagValue("tel", eElement)); // seq번호
				System.out.println(getTagValue("mapx", eElement));// 사업장명
				System.out.println(getTagValue("mapy", eElement));// 사업장명
				System.out.println(getTagValue("firstimage", eElement));// 사업장명
				System.out.println(getTagValue("firstimage1", eElement));// 사업장명
				System.out.println(getTagValue("readcount", eElement));// 사업장명
				System.out.println(getTagValue("areacode", eElement));// 사업장명
				

				stay.setTitle(getTagValue("title", eElement));
				stay.setAddress(getTagValue("addr1", eElement));
				stay.setTel(getTagValue("tel", eElement));
				// 더블로 넣을시 parsedouble 때문에 속도가 느려짐.
				stay.setMapX((getTagValue("mapx", eElement)));
				stay.setMapY((getTagValue("mapy", eElement)));
				stay.setFirstImage((getTagValue("firstimage", eElement)));
				stay.setSecondImage((getTagValue("firstimage1", eElement)));
				stay.setReadCount(Integer.parseInt((getTagValue("readcount", eElement))));
				stay.setAreacode((getTagValue("areacode", eElement)));
				try {
					CrawlingDao.insertStay(stay);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
