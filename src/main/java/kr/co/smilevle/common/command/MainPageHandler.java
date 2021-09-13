package kr.co.smilevle.common.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.corona.model.Corona;
import kr.co.smilevle.corona.service.CoronaService;
import kr.co.smilevle.tour.model.Tour;
import kr.co.smilevle.tour.service.TourService;
import kr.co.smilevle.util.MapInfomation;


public class MainPageHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		TourService tourService = new TourService();
		MapInfomation mapInfomation = new MapInfomation();
		List<Tour> stayList = new ArrayList<Tour>();
		List<Tour> travelDestList = new ArrayList<Tour>();
		List<Tour> eventList = new ArrayList<Tour>();
		
		CoronaService coronaService = new CoronaService();
		coronaService.updateCorona();
		Corona corona = coronaService.selectCoronaLowOrderRandom(5);
		List<Corona> coronaList = coronaService.selectCoronaList(10);
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		coronaList.remove(corona);
		
		Map<String, String> itemMap = mapInfomation.getContentMap();
		
		travelDestList = tourService.getContainer(corona.getAreaCode(), 20, "12");
		stayList = tourService.getContainer("false", 20, "32");
		eventList = tourService.getContainer(corona.getAreaCode(), 8, "15");
		
		
		req.setAttribute("corona", corona);
		req.setAttribute("stayList", stayList);
		req.setAttribute("travelDestList", travelDestList);
		req.setAttribute("eventList", eventList);
		req.setAttribute("itemMap", itemMap);
		return"/WEB-INF/views/index.jsp";
	}

	

	

}
