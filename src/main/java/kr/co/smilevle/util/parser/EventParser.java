package kr.co.smilevle.util.parser;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import kr.co.smilevle.event.model.Event;

public class EventParser {
	public List<Event> selectMainInfo(String parsingUrl) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		// 이 메소드 DocumentBuilder.parse(String)는 URI를 가져 와서 열려고 시도합니다.
		// 컨텐츠를 직접 제공하려면 컨텐츠를 InputStream또는 Reader로 지정해야합니다 .
		Document doc = null;
		try {
			doc = dBuilder.parse(new InputSource(new StringReader(parsingUrl)));
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();

		// doc.getDocumentElement().getNodeName() => 최상위 노드 확인
//      System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

		// 대장 노드
		NodeList nList = doc.getElementsByTagName("item");
//      System.out.println("파싱할 리스트 수 : " + nList.getLength());
		List<Event> eventList = new ArrayList<Event>();
		
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				Event event = new Event();

				event.setTitle(getTagValue("title", eElement));
				event.setAddress(getTagValue("addr1", eElement));
				event.setTel(getTagValue("tel", eElement));
				// 더블로 넣을시 parsedouble 때문에 속도가 느려짐.
				event.setMapX((getTagValue("mapx", eElement)));
				event.setMapY((getTagValue("mapy", eElement)));
				event.setFirstImage((getTagValue("firstimage", eElement)));
				event.setContentId((getTagValue("contentid", eElement)));
				event.setReadCount(Integer.parseInt((getTagValue("readcount", eElement))));
				event.setAreaCode((getTagValue("areacode", eElement)));
				event.setEventStartDate((getTagValue("eventstartdate", eElement)));
				event.setEventEndDate((getTagValue("eventenddate", eElement)));
				
				eventList.add(event);
			}
		}	
		return eventList;
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
