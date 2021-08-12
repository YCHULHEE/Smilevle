package mvc.controller;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvc.command.NullHandler;

public class ControllerUsingURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String,  CommandHandler> commandHandlerMap = new HashMap<String, CommandHandler>();
    
    @Override
    public void init() throws ServletException {
    	System.out.println("컨트롤러유징파일 서블릿 동작");
    	// web.xml 에서 컨피그파일을 가져온다.
    	String configFile = getInitParameter("configFile");
    	
    	// 파일 입출력으로 처리(파싱)가 가능하지만 Properties가 효율이 좋기에 사용한다.
    	Properties prop = new Properties();
    	// 서블릿의 실제 경로의 configfile을 저장한다.
    	String configFilePath = getServletContext().getRealPath(configFile);
//    	System.out.println("configFilePath의 경로" + configFilePath);
    	
    	try(FileReader fis = new FileReader(configFilePath)) {
    		prop.load(fis);
    		//System.out.println(fis);
    	} catch(IOException e) {
    		throw new ServletException(e);
    	}
    	// Iterator 열거형으로 정리하여 키 벨류 형태로 만든다.
    	Iterator<Object> keyIter = prop.keySet().iterator();
    	while(keyIter.hasNext()) {
    		// 키를 가져온다.
    		String command = (String) keyIter.next();
//    		System.out.println(command);
    		// 키에 따른 결과값을 가져온다.
    		String handlerClassName = prop.getProperty(command);
    		System.out.println("난 핸들러클래스 : "+ handlerClassName);
    		try {
    			// 값에 따른 로직 객체를 핸들러클래스에 넣게된다.
    			Class<?> handlerClass = Class.forName(handlerClassName);
    			// 공통 인터페이스인 커맨드 핸들러를 통하여 핸들러클래스에 있는 핸들러 객체를 생성시킨다.
    			CommandHandler handlerInstance = (CommandHandler)handlerClass.newInstance(); 
    			commandHandlerMap.put(command, handlerInstance);
    			
    			// 클래스를 찾지 못하는 경우 / 인스턴스를 발생 못 시키는 경우 / 맵에 없는 키를 요청할 경우 
    		} catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
    			e.getMessage();
    			throw new ServletException(e);
    		}
    	}
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String command = request.getParameter("cmd");
		
		String command = request.getRequestURI();
		if(command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length());
		}
		CommandHandler handler = commandHandlerMap.get(command);
		if(handler == null) {
			handler = new NullHandler();
		} 
		String viewPage = null;
		try {
			// 실제로 핸들러클래스에서 반환되는 jsp 경로.
			viewPage = handler.process(request, response);
		} catch (Exception e) {
			System.out.println( "이 값은 무엇"+viewPage);
			throw new ServletException(e);
		}
		
		if(viewPage != null) {
			// RequestDispatcher 없이 forward를 하게 되면 A.jsp -> Servlet -> B.jsp까지는
			// 파라미터 정보가 넘어가지만 그 다음 단계에서 A.jsp의 파라미터를 별도로 저장하지 않는다면
			// 소실되게 되어있음.
			RequestDispatcher dis = request.getRequestDispatcher(viewPage);
			dis.forward(request, response);
		}		
	}
}

