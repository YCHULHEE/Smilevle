package com.smilevle.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smilevle.login.model.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WriterFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		// 세션에 값이 있을시 저장하고 없을시 null 값을 저장한다.
		// 세션이 널이거나 세션에 있는 authUser 속성이 널일 때.
		HttpSession session = request.getSession();
	
		
		UserVO userVO = (UserVO)session.getAttribute("authUser");
		
		if(userVO == null) {
			HttpServletResponse response = (HttpServletResponse)res;
			// 로그인 페이지로 돌아가라고 응답한다.
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인이 필요한 서비스입니다.'); location.href='/login';</script>");
			out.flush();
		} else {
			// 필터를 실행하고 다음 필터로 넘어간다.
			chain.doFilter(req, res);
		}
	}
}
