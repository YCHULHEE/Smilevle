package kr.co.smilevle.common.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.corona.model.Corona;
import kr.co.smilevle.corona.service.CoronaService;
import kr.co.smilevle.stay.model.Stay;
import kr.co.smilevle.stay.service.StayService;
import kr.co.smilevle.util.MapInfomation;


public class MainPageHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		StayService tourService = new StayService();
		MapInfomation mapInfomation = new MapInfomation();
		List<Stay> stayList = new ArrayList<Stay>();
		List<Stay> travelDestList = new ArrayList<Stay>();
		List<Stay> eventList = new ArrayList<Stay>();
		
		CoronaService coronaService = new CoronaService();
		coronaService.updateCorona();
		Corona corona = coronaService.selectCoronaLowOrderRandom(3);
		List<Corona> coronaList = coronaService.selectCoronaList(10);
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		coronaList.remove(corona);
		
		Map<String, String> itemMap = mapInfomation.getContentMap();
		
		travelDestList = tourService.getContainer(corona.getAreaCode(), 20, "12");
		stayList = tourService.getContainer("false", 20, "32");
		eventList = tourService.getContainer(coronaList.get(random.nextInt(3)).getAreaCode(), 8, "15");
		
		
		req.setAttribute("corona", corona);
		req.setAttribute("stayList", stayList);
		req.setAttribute("travelDestList", travelDestList);
		req.setAttribute("eventList", eventList);
		req.setAttribute("itemMap", itemMap);
		return"/WEB-INF/views/index.jsp";
	}

	

	

}
