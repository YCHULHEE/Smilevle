package kr.co.smilevle.tour.service;

import java.util.List;

import kr.co.smilevle.tour.model.Tour;

public class TourPage {
	private int total;
	private int currentPage;
	private List<Tour> tourList;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public TourPage(int total, int currentPage, int size, List<Tour> tourList) {
		this.total = total;
		this.currentPage = currentPage;
		this.tourList = tourList;
		if(total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = total / size;
			 
			if (total % size > 0) {
				totalPages++;
			}
			// 
			int modVal = currentPage % 5;
			startPage = currentPage / 5 * 5 + 1;
			if (modVal == 0) startPage -= 5;
			
			endPage = startPage + 4;
	
			if(endPage > totalPages) endPage = totalPages;
		} 
	}
	
	public int getTotal() {
		return total;
	}
	
	public boolean hasNoStays() {
		return total == 0;
	}
	
	public boolean hasStays() {
		return total > 0;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<Tour> getTourList() {
		return tourList;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}	
}
