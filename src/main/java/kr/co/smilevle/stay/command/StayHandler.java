package kr.co.smilevle.stay.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.stay.model.Stay;
import kr.co.smilevle.stay.service.ListStayService;
import kr.co.smilevle.stay.service.StayPage;
import kr.co.smilevle.stay.service.StayService;

public class StayHandler implements CommandHandler{
	private ListStayService listStayService = new ListStayService();
		
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		StayPage stayPage = listStayService.getArticlePage(pageNo, "32");
		req.setAttribute("stayPage", stayPage);
		req.setAttribute("pageNo", pageNo + "");
		return "/WEB-INF/views/stay.jsp";
		
	}
	
	
}
