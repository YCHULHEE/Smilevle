package com.smilevle.tour.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smilevle.corona.model.CoronaVO;
import com.smilevle.corona.service.CoronaService;
import com.smilevle.tour.model.TourVO;
import com.smilevle.tour.service.TourData;
import com.smilevle.tour.service.TourPage;
import com.smilevle.tour.service.TourService;
import com.smilevle.util.MapInfomation;

@Controller
public class TourController {
	@Autowired
	private TourService tourService;
	@Autowired
	CoronaService coronaService;
	@Autowired
	MapInfomation mapInfomation;
	
	@RequestMapping({"/", ""})
	public String viewMainPage(Model model) throws IOException {
		coronaService.updateCorona();
//		
		CoronaVO corona = coronaService.selectCoronaLowOrderRandom(5);
//		List<CoronaVO> coronaList = coronaService.selectCoronaList(10);
//		
//		Random random = new Random();
//		random.setSeed(System.currentTimeMillis());
//		coronaList.remove(corona);

	
		model.addAttribute("travelDestList", tourService.getTourInfoContainer(corona.getAreaCode(), 20, "12"));
		model.addAttribute("stayList", tourService.getTourInfoContainer("", 20, "32"));
		model.addAttribute("eventList", tourService.getTourInfoContainer(corona.getAreaCode(), 8, "15"));
		model.addAttribute("itemMap", mapInfomation.getContentMap());
		return "index";
	}
	
	
	@RequestMapping(value = "stay")
	public String viewStay(@RequestParam(name = "pageNo", required = false) String pageNoVal, @RequestParam(name = "areaCode", required = false)String areaCode, @RequestParam(name = "smallCategory", required = false)String smallCategory, 
			@RequestParam(name = "searchWord", required = false)String searchWord, Model model) {
		int pageNo = 1;
		String where = "32";
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		TourPage page =tourService.getTourPage(pageNo, areaCode, smallCategory, where, searchWord);
		
		model.addAttribute("page", page);
		model.addAttribute("pageNo", pageNo +"");
		model.addAttribute("areaCode", areaCode);
		model.addAttribute("areaMap", mapInfomation.getAreaMap());
		model.addAttribute("itemMap", mapInfomation.getStayMap());
		model.addAttribute("smallCategory", smallCategory);
		model.addAttribute("where", where);
		model.addAttribute("searchWord", searchWord);
		
		return "stay";
	}
	
	@RequestMapping("tourOne")
	public String viewTourOne(@RequestParam(name ="contentId") String contentId, Model model) {
		int contentIdVal = Integer.parseInt(contentId);
		TourData tourData  = tourService.getTour(contentIdVal, true);
		
		String contentTypeId = tourData.getTourVO().getContentTypeId();
		String areaCode = tourData.getTourVO().getAreaCode();
		Map<String, String> itemMap = new HashMap<String, String>();
		List<TourVO> itemList = new ArrayList<TourVO>();
		
		if(contentTypeId.equals("32")) {
			itemMap = mapInfomation.getStayMap();
			itemList = tourService.getTourInfoContainer(areaCode, 9, "12");
		} else if(contentTypeId.equals("15")) {
			itemMap = mapInfomation.getEventMap();
			itemList = tourService.getTourInfoContainer(areaCode, 9, "32");
		} else if(contentTypeId.equals("12")) {
			itemMap = mapInfomation.getTravelDestMap();
			itemList = tourService.getTourInfoContainer(areaCode, 9, "32");
		} else {}
		
		model.addAttribute("itemList", itemList);
		model.addAttribute("tourData", tourData);
		model.addAttribute("where", contentTypeId);
		model.addAttribute("areaMap",  mapInfomation.getAreaMap());
		model.addAttribute("itemMap", itemMap);
		
		return "tour_one";
	}
	
	@GetMapping("tour_search")
	public String searchTour(@RequestParam(name = "pageNo", required = false) String pageNoVal, @RequestParam(name = "areaCode", required = false)String areaCode, @RequestParam(name = "smallCategory", required = false)String smallCategory, 
			@RequestParam(name = "searchWord", required = false)String searchWord, @RequestParam(name = "where", required = false)String contentTypeId, Model model) {
		
		String viewPage;
		
		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		Map<String, String> itemMap = new HashMap<String, String>();

		
		if(contentTypeId.equals("32")) {
			viewPage = "stay";
			itemMap = mapInfomation.getStayMap();
		} else if(contentTypeId.equals("15")) {
			viewPage = "event";
			itemMap = mapInfomation.getEventMap();
		} else if(contentTypeId.equals("12")) {
			viewPage = "travel_dest";
			itemMap = mapInfomation.getTravelDestMap();
		} else {
			viewPage = "stay";
		}
		
		TourPage page = tourService.getTourPage(pageNo, areaCode, smallCategory, contentTypeId, searchWord);
		
		model.addAttribute("page", page);
		model.addAttribute("pageNo", pageNo+"");
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("areaCode", areaCode);
		model.addAttribute("smallCategory", smallCategory);
		model.addAttribute("where", contentTypeId);
		model.addAttribute("areaMap",  mapInfomation.getAreaMap());
		model.addAttribute("itemMap", itemMap);
		
		return viewPage;
	}
	

}
