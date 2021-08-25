package kr.co.smilevle.review.service;

import java.util.Map;

public class ModifyRequest {
	private String userId;
	private int reviewNumber;
	private String title;
	private String areacode;
	private String locationName;
	private String rate;
	private String content;
	
	public ModifyRequest(String userId, int reviewNumber, String title, String areacode, String locationName,
			String rate, String content) {
		super();
		this.userId = userId;
		this.reviewNumber = reviewNumber;
		this.title = title;
		this.areacode = areacode;
		this.locationName = locationName;
		this.rate = rate;
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public int getReviewNumber() {
		return reviewNumber;
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
