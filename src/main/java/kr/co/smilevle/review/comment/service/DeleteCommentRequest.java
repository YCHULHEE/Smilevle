package kr.co.smilevle.review.comment.service;

public class DeleteCommentRequest {
	private String userId;
	private int commentNumber;
	
	public DeleteCommentRequest(String userId, int commentNumber) {
		super();
		this.userId = userId;
		this.commentNumber = commentNumber;
	}

	public String getUserId() {
		return userId;
	}

	public int getCommentNumber() {
		return commentNumber;
	}
	
}
