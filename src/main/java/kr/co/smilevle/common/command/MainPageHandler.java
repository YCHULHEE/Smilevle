package kr.co.smilevle.common.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.stay.model.Stay;
import kr.co.smilevle.stay.service.StayService;
import kr.co.smilevle.tourlist.model.Tourlist;
import kr.co.smilevle.tourlist.service.TourlistService;

public class MainPageHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StayService stayService = new StayService();
		TourlistService tourlistService = new TourlistService();
		List<Stay> stayList = new ArrayList<Stay>();
		List<Tourlist> tourlists = new ArrayList<Tourlist>();
		
		tourlists = tourlistService.select("20", "32");
		
		stayList = stayService.printStayMain();
		request.setAttribute("list", stayList);
		request.setAttribute("tourList", tourlists);
		
		return"/WEB-INF/views/index.jsp";
	}

}
