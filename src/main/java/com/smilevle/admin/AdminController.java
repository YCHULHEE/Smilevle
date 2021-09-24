package com.smilevle.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smilevle.tour.model.TourVO;
import com.smilevle.tour.service.TourService;





	@Controller
	@RequestMapping("/admin/*")
	public class AdminController {
		private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
		@Autowired
		private TourService tourService;
		
		@RequestMapping(value = "/goods/register", method = RequestMethod.GET)
		public void getGoodsResiger(Model model) throws Exception {
			logger.info("get goods register");
			
			
		}
		
		@RequestMapping(value = "/goods/list", method = RequestMethod.GET)
		public void getGoodsList(Model model) throws Exception {
			logger.info("get goods list");
			
			model.addAttribute("stayList", tourService.getTourInfoContainer("", 5, "32"));
		}
		
		@RequestMapping(value="/member/list", method=RequestMethod.GET)
		public void getMemberList(Model model) throws Exception{
			logger.info("get member list");
			
		}
	
		
}
