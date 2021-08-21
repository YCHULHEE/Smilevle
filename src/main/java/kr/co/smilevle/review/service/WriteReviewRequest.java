package kr.co.smilevle.review.service;

import java.io.Writer;
import java.util.Map;

public class WriteReviewRequest {
	private Writer writer;
	private String title;
	private int areacode;
	private String locationName;
	private double rate;
	private String content;
	
	public WriteReviewRequest(Writer writer, String title, int areacode, String locationName, double rate,
			String content) {
		super();
		this.writer = writer;
		this.title = title;
		this.areacode = areacode;
		this.locationName = locationName;
		this.rate = rate;
		this.content = content;
	}

	public Writer getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public int getAreacode() {
		return areacode;
	}

	public String getLocationName() {
		return locationName;
	}

	public double getRate() {
		return rate;
	}

	public String getContent() {
		return content;
	}
	
	public void validate(Map<String, Boolean> errors, String value, String fieldName) {
		if(value == null || value.isEmpty()) {
			errors.put(fieldName, Boolean.TRUE);
		}
	}
}
