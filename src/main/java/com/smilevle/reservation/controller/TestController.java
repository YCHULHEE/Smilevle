package com.smilevle.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("")
	public String home() {
		return "/reservation/reservation";
	}
	

}
