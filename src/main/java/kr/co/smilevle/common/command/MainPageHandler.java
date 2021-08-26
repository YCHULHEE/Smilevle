package kr.co.smilevle.common.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.event.model.Event;
import kr.co.smilevle.event.service.EventService;
import kr.co.smilevle.stay.model.Stay;
import kr.co.smilevle.stay.service.StayService;
import kr.co.smilevle.travel.model.TravelDest;
import kr.co.smilevle.travel.service.TravelDestService;

public class MainPageHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		StayService stayService = new StayService();
		TravelDestService travelDestService = new TravelDestService();
		EventService eventService = new EventService();
		
		List<Stay> stayList = new ArrayList<Stay>();
		List<TravelDest> travelDestList = new ArrayList<TravelDest>();
		List<Event> eventList = new ArrayList<Event>();
		
		
		travelDestList = travelDestService.printTourListMain("20", "32");
		stayList = stayService.getStayContainer("32", 20);
		eventList = eventService.printEventMain(8, "32");
	
		req.setAttribute("stayList", stayList);
		req.setAttribute("travelDestList", travelDestList);
		req.setAttribute("eventList", eventList);
		
		return"/WEB-INF/views/index.jsp";
	}

	

	

}
