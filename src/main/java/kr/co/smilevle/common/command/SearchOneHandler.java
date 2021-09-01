package kr.co.smilevle.common.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.tour.service.ListTourService;
import kr.co.smilevle.tour.service.TourData;
import kr.co.smilevle.tour.service.TourPage;
import kr.co.smilevle.tour.service.TourService;
import kr.co.smilevle.util.MapInfomation;

public class SearchOneHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/views/stay_one.jsp";
	private TourService tourService = new TourService();
	private ListTourService listService = new ListTourService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processGet(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processForm(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String contentIdVal = req.getParameter("contentId");
		System.out.println(contentIdVal);
		int contentId = Integer.parseInt(contentIdVal);
		TourData tourData= tourService.getStay(contentId, true);
		req.setAttribute("stayData", tourData);
		
		return FORM_VIEW;
	}
	
	private String processGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String pageNoVal = req.getParameter("pageNo");
		String smallCategory = req.getParameter("smallCategory");
		String where = req.getParameter("where");
		String searchWord = req.getParameter("searchWord");
		String areaCode = req.getParameter("areaCode");
		
		String viewPage;
		
		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}

		
		MapInfomation mapInfomation = new MapInfomation();
		Map<String, String> areaMap = mapInfomation.getAreaMap();
		Map<String, String> itemMap = new HashMap<String, String>();
		
		if(where.equals("32")) {
			viewPage = "/WEB-INF/views/stay.jsp";
			itemMap = mapInfomation.getStayMap();
		} else if(where.equals("15")) {
			viewPage = "/WEB-INF/views/event.jsp";
			itemMap = mapInfomation.getEventMap();
		} else if(where.equals("12")) {
			viewPage = "/WEB-INF/views/travel_dest.jsp";
			itemMap = mapInfomation.getTravelDestMap();
		} else {
			viewPage = FORM_VIEW;
		}
		TourPage page = listService.getArticlePage(pageNo, areaCode, smallCategory, where, searchWord);
		req.setAttribute("page", page);
		req.setAttribute("pageNo", pageNo + "");
		req.setAttribute("areaCode", areaCode);
		req.setAttribute("areaMap", areaMap);
		req.setAttribute("itemMap", itemMap);
		req.setAttribute("smallCategory",  smallCategory);
		req.setAttribute("where", where);
		req.setAttribute("searchWord", searchWord);

		return viewPage;
	}
}
