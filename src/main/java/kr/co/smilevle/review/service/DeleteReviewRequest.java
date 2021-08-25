package kr.co.smilevle.review.service;

public class DeleteReviewRequest {
	private String userId;
	private int reviewNumber;
	
	public DeleteReviewRequest(String userId, int reviewNumber) {
		super();
		this.userId = userId;
		this.reviewNumber = reviewNumber;
	}

	public String getUserId() {
		return userId;
	}

	public int getReviewNumber() {
		return reviewNumber;
	}
	
}	
