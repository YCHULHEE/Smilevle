package kr.co.smilevle.travel.service;

import java.util.List;

import kr.co.smilevle.travel.model.TravelDest;
import kr.co.smilevle.travel.model.TravelDestContent;

public class TravelDestData {
	private TravelDest travelDest;
	private TravelDestContent travelDestContent;
	private List<String> imageList;
	
	public List<String> getImageList() {
		return imageList;
	}
	public TravelDest getTravelDest() {
		return travelDest;
	}
	public TravelDestContent getTravelDestContent() {
		return travelDestContent;
	}
	public TravelDestData(TravelDest travelDest, TravelDestContent travelDestContent, List<String> imageList) {
		this.travelDest = travelDest;
		this.travelDestContent = travelDestContent;
		this.imageList = imageList;
	}
}
