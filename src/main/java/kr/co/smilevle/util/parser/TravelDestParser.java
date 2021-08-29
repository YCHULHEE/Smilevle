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

import kr.co.smilevle.travel.model.TravelDest;
import kr.co.smilevle.travel.model.TravelDestContent;

public class TravelDestParser {
	public List<TravelDest> selectMainInfo(String parsingUrl) {
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

		List<TravelDest> travelDests = new ArrayList<TravelDest>();

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				TravelDest travelDest = new TravelDest();

				travelDest.setTitle(getTagValue("title", eElement));
				travelDest.setAddress(getTagValue("addr1", eElement));
				travelDest.setTel(getTagValue("tel", eElement));
				// 더블로 넣을시 parsedouble 때문에 속도가 느려짐.
				travelDest.setMapX((getTagValue("mapx", eElement)));
				travelDest.setMapY((getTagValue("mapy", eElement)));
				travelDest.setFirstImage((getTagValue("firstimage", eElement)));
				if (!getTagValue("contentid", eElement).equals("")) {
					travelDest.setContentId(Integer.parseInt(getTagValue("contentid", eElement)));
				} else {
					continue;
				}
				travelDest.setReadCount(Integer.parseInt((getTagValue("readcount", eElement))));
				travelDest.setAreaCode((getTagValue("areacode", eElement)));

				travelDests.add(travelDest);
			}
		}
		return travelDests;
	}
	
	public TravelDestContent selectOne(String parsingUrl) {
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
		TravelDestContent travelDestContent = new TravelDestContent();

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;

				if (!getTagValue("contentid", eElement).equals("")) {
					travelDestContent.setContentId(Integer.parseInt(getTagValue("contentid", eElement)));
				} else {
					continue;
				}
				travelDestContent.setContent(getTagValue("overview", eElement));
				travelDestContent.setHomePage(getTagValue("homepage", eElement));
			}
		}
		return travelDestContent;
	}
	
	
	public String selectImageList(String parsingUrl) {
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
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				if(i == nList.getLength()) {
					sb.append(getTagValue("originimgurl", eElement));
					continue;
				}
				sb.append(getTagValue("originimgurl", eElement) + ",");
			}
		}
		return sb.toString();
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
