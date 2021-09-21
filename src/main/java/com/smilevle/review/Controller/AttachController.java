package com.smilevle.review.Controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

@Controller
@RequestMapping("/upload")
public class AttachController {

	@RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
	@ResponseBody
	public String uploadAttach(HttpServletRequest request, HttpServletResponse response) throws Exception {

		final String SAVE_URL = "files";
		
		ServletContext context = request.getServletContext();
		String saveDirectory = context.getRealPath(SAVE_URL);
		System.out.println("업로드 경로: " + saveDirectory);
		
		Enumeration names = null;
		String name = null;
		String originalFileName = null;
		String fileSystemName = null;
		String fileType = null;
		String fileUrl = null;
		
		int maxPostSize = 10 * 1024 * 1024;
		String encoding = "UTF-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		names = multi.getFileNames();
		while(names.hasMoreElements()) {
			name = (String) names.nextElement();
			System.out.println("input name: " + name);
			
			originalFileName = multi.getOriginalFileName(name);
			fileSystemName = multi.getFilesystemName(name);
			fileType = multi.getContentType(name);
			
			fileUrl = request.getContextPath() + "/" + SAVE_URL + "/" + fileSystemName;
			System.out.println("fileURL: " + fileUrl);
		}
		
		String jsonString = "{\"filename\" : \"" + fileSystemName + "\", \"uploaded\" : 1, \"url\":\"" + fileUrl + "\"}";
		
		try {
			request.getSession(false).setAttribute("fileUrl", fileUrl);
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().write(jsonString);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
