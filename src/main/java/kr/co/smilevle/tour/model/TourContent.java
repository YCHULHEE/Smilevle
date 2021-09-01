package kr.co.smilevle.tour.model;

public class TourContent {
	private Integer contentId;
	private String content;
	private String homePage;
	private String imageList;
	
	public String getImageList() {
		return imageList;
	}
	public void setImageList(String imageList) {
		this.imageList = imageList;
	}
	public Integer getContentId() {
		return contentId;
	}
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	public TourContent(Integer contentId, String content, String homePage, String imageList) {
		super();
		this.contentId = contentId;
		this.content = content;
		this.homePage = homePage;
		this.imageList = imageList; 
	}
	public TourContent() {
		
	}
}
