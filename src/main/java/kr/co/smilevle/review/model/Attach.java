package kr.co.smilevle.review.model;

public class Attach {
	private Integer photoNo;
	private Integer reviewNo;
	private String photoUrl;
	
	public Attach(Integer photoNo, Integer reviewNo, String photoUrl) {
		super();
		this.photoNo = photoNo;
		this.reviewNo = reviewNo;
		this.photoUrl = photoUrl;
	}

	public Integer getPhotoNo() {
		return photoNo;
	}

	public Integer getReviewNo() {
		return reviewNo;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}
	
}
