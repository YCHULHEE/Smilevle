package kr.co.smilevle.tour.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.tour.model.Tour;
import kr.co.smilevle.tour.service.TourData;
import kr.co.smilevle.tour.service.TourService;
import kr.co.smilevle.util.MapInfomation;


public class TourOneHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/views/tour_one.jsp";
	private TourService tourService = new TourService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return FORM_VIEW;
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String contentId = req.getParameter("contentId");
		String where = req.getParameter("where");
		MapInfomation mapInfomation = new MapInfomation();
		Map<String, String> areaMap = mapInfomation.getAreaMap();
		
		int contentIdVal = Integer.parseInt(contentId);
		TourData tourData= tourService.getStay(contentIdVal, true);
		String areaCode = tourData.getStay().getAreaCode();
		String contentTypeId = tourData.getStay().getContentTypeId();
		Map<String, String> itemMap = new HashMap<String, String>();
		List<Tour> itemList = new ArrayList<Tour>();
		
		if(contentTypeId.equals("32")) {
			itemMap = mapInfomation.getStayMap();
			itemList = tourService.getContainer(areaCode, 9, "12");
		} else if(contentTypeId.equals("15")) {
			itemMap = mapInfomation.getEventMap();
			itemList = tourService.getContainer(areaCode, 9, "32");
		} else if(contentTypeId.equals("12")) {
			itemMap = mapInfomation.getTravelDestMap();
			itemList = tourService.getContainer(areaCode, 9, "32");
		} else {}
		
		req.setAttribute("itemList", itemList);
		req.setAttribute("stayData", tourData);
		req.setAttribute("where", where);
		req.setAttribute("areaMap", areaMap);
		req.setAttribute("itemMap", itemMap);
		return FORM_VIEW;
	}




	
}
