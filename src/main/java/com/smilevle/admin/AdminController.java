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
import com.smilevle.tour.service.TourData;
import com.smilevle.tour.service.TourPage;
import com.smilevle.tour.service.TourService;
import com.smilevle.util.MapInfomation;
import com.smilevle.util.UploadFileUtils;


@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private TourService tourService;
	@Autowired
	MapInfomation mapInfomation;
	
	String uploadPath = "C:\\Users\\Admin\\Desktop\\Smile\\Smilevle\\src\\main\\resources\\static\\goodImages";
	
	@RequestMapping(value = "index")
	public String getAdminIndex() throws Exception {
		return "admin/index";
	}
	
	@RequestMapping(value = "/goods/register")
	public void getGoodsResiger(Model model) throws Exception {
		logger.info("get goods register");
		model.addAttribute("areaMap", mapInfomation.getAreaMap());
		model.addAttribute("itemMap", mapInfomation.getStayMap());
	}
	
	
	@RequestMapping(value = "/goods/register", method = RequestMethod.POST)
	public String postGoodsRegister(TourVO vo, MultipartFile file) throws Exception {
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
			vo.setFirstImage("/static/goodImages/imgUpload" + ymdPath + "/" + fileName);
		} else {
			fileName = File.separator + "images" + File.separator + "none.png";
			vo.setFirstImage(fileName);
		}

		tourService.register(vo);
		return "redirect:/admin/index";
	}

	@RequestMapping(value = "/goods/list", method = RequestMethod.GET)
	public void getGoodsList(@RequestParam(name = "pageNo", required = false) String pageNoVal, @RequestParam(name = "areaCode", required = false)String areaCode, @RequestParam(name = "smallCategory", required = false)String smallCategory, 
			@RequestParam(name = "searchWord", required = false)String searchWord, Model model) {
		int pageNo = 1;
		String where = "32";
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		TourPage page =tourService.getTourPage(pageNo, areaCode, smallCategory, where, searchWord, 5);
		
		model.addAttribute("page", page);
		model.addAttribute("pageNo", pageNo +"");
		model.addAttribute("areaCode", areaCode);
		model.addAttribute("areaMap", mapInfomation.getAreaMap());
		model.addAttribute("itemMap", mapInfomation.getStayMap());
		model.addAttribute("smallCategory", smallCategory);
		model.addAttribute("where", where);
		model.addAttribute("searchWord", searchWord);
	}

//		@RequestMapping(value="/goods/Sample", method=RequestMethod.GET)
//		public void getMemberList(Model model) throws Exception{
//			logger.info("get member list");
//			
//		}

	@RequestMapping(value = "/goods/view", method = RequestMethod.GET)
	public void getGoodsview(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("get goods view");		
	}
	
	@RequestMapping(value = "/goods/modify", method = RequestMethod.GET)
	public void getGoodsModify(@RequestParam("contentId") int contentId, Model model) throws Exception {
		logger.info("get goods modify");
		model.addAttribute("areaMap", mapInfomation.getAreaMap());
		model.addAttribute("itemMap", mapInfomation.getStayMap());
		TourData tourData = tourService.getTour(contentId, false); 
		TourVO item = tourData.getTourVO(); 
		item.setHomepage("홈페이지없음");
		model.addAttribute("item", item);
	}

	@RequestMapping(value = "/goods/modify", method = RequestMethod.POST)
	public String postGoodsModify(TourVO vo, MultipartFile file) throws Exception {
		logger.info("post goods modify");
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
//		if(vo.getFirstImage().contains("http")) {
//			
//		} else
			if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
//			new File(uploadPath + firstImage).delete();
//			new File(uploadPath + firstImage).delete();
			
			fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
			vo.setFirstImage("/static/goodImages/imgUpload" + ymdPath + "/" + fileName);
		} else {
			fileName = File.separator + "images" + File.separator + "none.png";
			vo.setFirstImage(fileName);
		}
		
		tourService.tourModify(vo);
		return "redirect:/admin/index";
	}
	
	@RequestMapping(value = "/goods/delete", method = RequestMethod.GET)
	public String postGoodsDelete(@RequestParam("contentId") int contentId) throws Exception {
		logger.info("goods delete");
		tourService.tourDelete(contentId);
		return "redirect:/admin/goods/list?";
	}
	
	@RequestMapping(value="/member/list", method=RequestMethod.GET)
	public void getMemberList(Model model) throws Exception{
		logger.info("get member list");
		
//		List<MemberVO> memberList = adminService.memberList();
//		
//		model.addAttribute("memberList", memberList);
	}

	@RequestMapping(value = "/goods/Sample")
	public void getJusoList(Model model) throws Exception {
	}

	@RequestMapping(value = "/goods/jusoPopup")
	public void getJusoSearch(Model model) throws Exception {

	}

}
