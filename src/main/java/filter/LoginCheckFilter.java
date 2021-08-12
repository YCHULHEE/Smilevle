

package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		// 세션에 값이 있을시 저장하고 없을시 null 값을 저장한다.
		HttpSession session = request.getSession(false);
		// 세션이 널이거나 세션에 있는 authUser 속성이 널일 때.
		if(session == null || session.getAttribute("authUser") == null) {
			HttpServletResponse response = (HttpServletResponse)res;
			// 로그인 페이지로 돌아가라고 응답한다.
			response.sendRedirect(request.getContextPath() + "/login.do");
		} else {
			// 필터를 실행하고 다음 필터로 넘어간다.
			chain.doFilter(req, res);
		}
	}	

	@Override
	public void destroy() {
		
	}
	
}
