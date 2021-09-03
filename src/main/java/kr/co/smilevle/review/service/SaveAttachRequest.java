package kr.co.smilevle.review.service;

public class SaveAttachRequest {
	private Integer reviewNo;
	private String photoUrl;
	
	public SaveAttachRequest(Integer reviewNo) {
		this.reviewNo = reviewNo;
	}
	
	public SaveAttachRequest(Integer reviewNo, String photoUrl) {
		this.reviewNo = reviewNo;
		this.photoUrl = photoUrl;
	}

	public Integer getReviewNo() {
		return reviewNo;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}
	
}
