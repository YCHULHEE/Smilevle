package kr.co.smilevle.tour.service;

import kr.co.smilevle.tour.model.Tour;
import kr.co.smilevle.tour.model.TourContent;

public class TourData {
	private Tour tour;
	private TourContent content;
	private String[] imageList;
	
	public String[] getImageList() {
		return imageList;
	}
	public Tour getStay() {
		return tour;
	}
	public TourContent getStayContent() {
		return content;
	}
	public TourData(Tour tour, TourContent content, String[] imageList) {
		this.tour = tour;
		this.content = content;
		this.imageList = imageList;
	}
}
