package kr.co.smilevle.travel.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.travel.model.TravelDest;
import kr.co.smilevle.travel.service.TravelDestData;
import kr.co.smilevle.travel.service.TravelDestService;

public class TravelDestOneHandler implements CommandHandler{
	
	private static final String FORM_VIEW = "/WEB-INF/views/travel_dest_one.jsp";
	private TravelDestService travelDestService = new TravelDestService();
	
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
		TravelDestData travelDestData = travelDestService.getTravelDest(contentId, true);
		req.setAttribute("travelDestData", travelDestData);
		
		return FORM_VIEW;
	}
}
