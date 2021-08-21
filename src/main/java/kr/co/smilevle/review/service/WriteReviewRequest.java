package kr.co.smilevle.review.service;

import java.util.Map;

import kr.co.smilevle.review.model.Writer;

public class WriteReviewRequest {
	private Writer writer;
	private String title;
	private String areacode;
	private String locationName;
	private String rate;
	private String content;
	
	public WriteReviewRequest(Writer writer, String title, String areacode, String locationName, String rate,
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

	public String getAreacode() {
		return areacode;
	}

	public String getLocationName() {
		return locationName;
	}

	public String getRate() {
		return rate;
	}

	public String getContent() {
		return content;
	}
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, title, "title");
		checkEmpty(errors, areacode, "areacode");
		checkEmpty(errors, rate, "rate");
		checkEmpty(errors, locationName, "locationName");
	}
	
	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if(value == null || value.isEmpty()) {
			errors.put(fieldName, Boolean.TRUE);
		}
	}
}
