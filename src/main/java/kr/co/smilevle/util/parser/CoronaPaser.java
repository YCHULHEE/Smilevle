package kr.co.smilevle.util.parser;


import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



public class CoronaPaser {
	public Map<String, Integer> paserCorona(String parsingUrl) {
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
		Map<String, Integer> coronaMap = new HashMap<String, Integer>();
		
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				if((getTagValue("gubun", eElement).equals("합계"))) {
					continue;
				}
				
				coronaMap.put(getTagValue("gubun", eElement), 
						Integer.parseInt(getTagValue("localOccCnt", eElement)));
			}
		}
		return coronaMap;
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
