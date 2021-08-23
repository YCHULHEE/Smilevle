package kr.co.smilevle.travel.model;

public class TravelDestContent {
	private Integer contentId;
	private String content;
	private String homePage;
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
	public TravelDestContent(Integer contentId, String content, String homePage) {
		super();
		this.contentId = contentId;
		this.content = content;
		this.homePage = homePage;
	}
	public TravelDestContent() {
		
	}
}
