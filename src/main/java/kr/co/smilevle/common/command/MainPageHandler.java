package kr.co.smilevle.common.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.smilevle.stay.model.Stay;
import kr.co.smilevle.stay.service.StayService;

public class MainPageHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StayService stayService = new StayService();
		List<Stay> stayList = new ArrayList<Stay>();
		stayList = stayService.printStayMain();
		request.setAttribute("list", stayList);
		return"/WEB-INF/views/index.jsp";
	}

}
