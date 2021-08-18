package kr.co.smilevle.common.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.event.model.Event;
import kr.co.smilevle.event.service.EventService;
import kr.co.smilevle.stay.model.Stay;
import kr.co.smilevle.stay.service.StayService;
import kr.co.smilevle.tourlist.model.Tourlist;
import kr.co.smilevle.tourlist.service.TourlistService;

public class MainPageHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		StayService stayService = new StayService();
		TourlistService tourlistService = new TourlistService();
		EventService eventService = new EventService();
		
		List<Stay> stayList = new ArrayList<Stay>();
		List<Tourlist> tourlists = new ArrayList<Tourlist>();
		List<Event> eventList = new ArrayList<Event>();
		
		
		tourlists = tourlistService.printTourListMain("20", "32");
		stayList = stayService.printStayMain();
		eventList = eventService.printEventMain("8", "32");
		
		req.setAttribute("list", stayList);
		req.setAttribute("tourList", tourlists);
		req.setAttribute("eventList", eventList);
		
		return"/WEB-INF/views/index.jsp";
	}

	

	

}
