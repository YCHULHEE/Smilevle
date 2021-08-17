package kr.co.smilevle.util.parser;

import java.io.IOException;
import java.io.StringReader;
import java.sql.SQLException;
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

import kr.co.smilevle.tourlist.model.Tourlist;

public class TourlistParser {
	public List<Tourlist> selectMainInfo(String parsingUrl) {
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
		List<Tourlist> tourlists = new ArrayList<Tourlist>();
		
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				Tourlist tourlist = new Tourlist();

				tourlist.setTitle(getTagValue("title", eElement));
				tourlist.setAddress(getTagValue("addr1", eElement));
				tourlist.setTel(getTagValue("tel", eElement));
				// 더블로 넣을시 parsedouble 때문에 속도가 느려짐.
				tourlist.setMapX((getTagValue("mapx", eElement)));
				tourlist.setMapY((getTagValue("mapy", eElement)));
				tourlist.setFirstImage((getTagValue("firstimage", eElement)));
				tourlist.setcontentId((getTagValue("contentid", eElement)));
				tourlist.setReadCount(Integer.parseInt((getTagValue("readcount", eElement))));
				tourlist.setareaCode((getTagValue("areacode", eElement)));
				
				tourlists.add(tourlist);
			}
		}	
		return tourlists;
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
