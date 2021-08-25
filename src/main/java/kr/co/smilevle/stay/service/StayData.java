package kr.co.smilevle.stay.service;

import java.util.List;

import kr.co.smilevle.stay.model.Stay;
import kr.co.smilevle.stay.model.StayContent;
import kr.co.smilevle.travel.model.TravelDestContent;



public class StayData {
	private Stay stay;
	private TravelDestContent stayContent;
	private List<String> imageList;
	
	public List<String> getImageList() {
		return imageList;
	}
	public Stay getStay() {
		return stay;
	}
	public TravelDestContent getStayContent() {
		return stayContent;
	}
	public StayData(Stay stay, TravelDestContent content, List<String> imageList) {
		this.stay = stay;
		this.stayContent = content;
		this.imageList = imageList;
	}
}
