package kr.co.smilevle.review.comment.service;

public class WriteCommentRequest {
	private Integer reviewNumber;
	private String writerId;
	private String content;
	
	public WriteCommentRequest(Integer reviewNumber, String writerId, String content) {
		this.reviewNumber = reviewNumber;
		this.writerId = writerId;
		this.content = content;
	}
	
	public Integer getReviewNumber() {
		return reviewNumber;
	}

	public String getWriterId() {
		return writerId;
	}

	public String getContent() {
		return content;
	}
}
