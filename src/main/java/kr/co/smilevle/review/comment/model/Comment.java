package kr.co.smilevle.review.comment.model;

import java.util.Date;

public class Comment {
	private Integer commentNo;
	private Integer reviewNo;
	private String writerId;
	private Date regDate;
	private String content;
	
	public Comment(Integer commentNo, Integer reviewNo, String writerId, Date regDate, String content) {
		this.commentNo = commentNo;
		this.reviewNo = reviewNo;
		this.writerId = writerId;
		this.regDate = regDate;
		this.content = content;
	}

	public Integer getCommentNo() {
		return commentNo;
	}

	public Integer getReviewNo() {
		return reviewNo;
	}

	public String getWriterId() {
		return writerId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public String getContent() {
		return content;
	}
}
