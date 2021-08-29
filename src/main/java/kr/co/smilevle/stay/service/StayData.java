package kr.co.smilevle.stay.service;

import kr.co.smilevle.stay.model.Stay;
import kr.co.smilevle.stay.model.StayContent;

public class StayData {
	private Stay stay;
	private StayContent content;
	private String[] imageList;
	
	public String[] getImageList() {
		return imageList;
	}
	public Stay getStay() {
		return stay;
	}
	public StayContent getStayContent() {
		return content;
	}
	public StayData(Stay stay, StayContent content, String[] imageList) {
		this.stay = stay;
		this.content = content;
		this.imageList = imageList;
	}
}
