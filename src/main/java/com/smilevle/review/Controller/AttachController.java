package com.smilevle.review.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;

@Controller
@RequestMapping("/upload")
public class AttachController {
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
	@ResponseBody
	public void uploadAttach(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload) throws Exception {
		String uploadPath = request.getSession().getServletContext().getRealPath("/").concat("resource\\ckUpload");
		System.out.println("uploadPath  : " + uploadPath);
		
		UUID uid = UUID.randomUUID();
		
		OutputStream out = null;
		PrintWriter printWriter = null;
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		try {
			String fileName = upload.getOriginalFilename();
			byte[] bytes = upload.getBytes();
			
			String ckUploadPath = uploadPath + File.separator + uid + "_" + fileName;
			System.out.println("ckUploadPath: " + ckUploadPath);
			
			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			out.flush();
			
			printWriter = response.getWriter();
			String fileUrl = "/ckUpload/" + uid + "_" + fileName;
			JsonObject json = new JsonObject();
			json.addProperty("uploaded", 1);
			json.addProperty("fileName", fileName);
			json.addProperty("url", fileUrl);
			printWriter.println(json);
			System.out.println("fileUrl: " +fileUrl);
	
			request.getSession(false).setAttribute("fileUrl", fileUrl);
			
			printWriter.flush();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(out != null) out.close();
				if(printWriter != null) printWriter.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		return;
	}
}
