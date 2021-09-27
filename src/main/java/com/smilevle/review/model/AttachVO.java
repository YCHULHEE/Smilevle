package com.smilevle.review.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AttachVO {
	private Integer photoNo;
	private Integer reviewNo;
	private String photoUrl;
	
	public AttachVO(Integer photo_no, Integer review_no) {
		super();
		this.photoNo = photo_no;
		this.reviewNo = review_no;
	}
}
