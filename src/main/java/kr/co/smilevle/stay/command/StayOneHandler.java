package kr.co.smilevle.stay.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.stay.service.StayData;
import kr.co.smilevle.stay.service.StayService;


public class StayOneHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/views/stay_one.jsp";
	private StayService stayService = new StayService();
	
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
		String contentIdVal = req.getParameter("contentId");
		System.out.println(contentIdVal);
		int contentId = Integer.parseInt(contentIdVal);
		StayData stayData= stayService.getStay(contentId, true);
		req.setAttribute("stayData", stayData);
		
		return FORM_VIEW;
	}




	
}
