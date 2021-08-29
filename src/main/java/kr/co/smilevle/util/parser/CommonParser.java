package kr.co.smilevle.util.parser;

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

import kr.co.smilevle.stay.model.StayContent;
import kr.co.smilevle.util.crawling.CommonCrawler;

public class CommonParser {

	
	public StayContent selectOne(String parsingUrl, String firstImage, int contentId) throws IOException {
		CommonCrawler commonCrawler =new CommonCrawler();
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
		StayContent stayContent = new StayContent();
		
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				
				stayContent.setContentId(contentId);
				stayContent.setContent(getTagValue("overview", eElement));
				if(getTagValue("homepage", eElement).equals("")) {
					stayContent.setHomePage("홈페이지 없음");
				} else {
					stayContent.setHomePage(getTagValue("homepage", eElement));
				}
				
				String imageList = commonCrawler.selectImageListById(stayContent.getContentId(), firstImage);
				
				stayContent.setImageList(imageList);
			}
		}
		return stayContent;
	}
	
	
	public String selectImageList(String parsingUrl, String firstImage) {
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
				if(i == (nList.getLength() - 1)) {
					sb.append(getTagValue("originimgurl", eElement));
					continue;
				}
				sb.append(getTagValue("originimgurl", eElement) + ",");
			}
		}
		String imageList = sb.toString();
		
		if(imageList.equals("")) {
			imageList = firstImage;
		}
		return imageList;
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
