package kr.co.smilevle.event.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.corona.model.Corona;
import kr.co.smilevle.corona.service.CoronaService;
import kr.co.smilevle.stay.service.ListStayService;
import kr.co.smilevle.stay.service.StayPage;
import kr.co.smilevle.util.MapInfomation;

public class EventHandler implements CommandHandler {
	private ListStayService listService = new ListStayService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String pageNoVal = req.getParameter("pageNo");
		String areaCode = req.getParameter("areaCode");
		String smallCategory = req.getParameter("smallCategory");
		String where = req.getParameter("where");
		String searchWord = req.getParameter("searchWord");

		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
			
		MapInfomation mapInfomation = new MapInfomation();
		Map<String, String> areaMap = mapInfomation.getAreaMap();
		Map<String, String> itemMap = mapInfomation.getEventMap();
		StayPage page = listService.getArticlePage(pageNo, areaCode, smallCategory, where, searchWord);
		req.setAttribute("page", page);
		req.setAttribute("pageNo", pageNo + "");
		req.setAttribute("areaCode", areaCode);
		req.setAttribute("areaMap", areaMap);
		req.setAttribute("itemMap", itemMap);
		req.setAttribute("smallCategory",  smallCategory);
		req.setAttribute("where", where);
		req.setAttribute("searchWord", searchWord);
		
		return "/WEB-INF/views/event.jsp";
	}
}
