package com.smilevle.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smilevle.tour.service.TourService;

@Controller
public class TourController {
	@Autowired
	private TourService tourService;
	
	@RequestMapping("/hi")
	public String mainPage(Model model) {
		model.addAttribute("travelDestList", tourService.getTourInfoContainer("", 20, "12"));
		
		return "index";
	}

}
