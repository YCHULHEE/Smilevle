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
	private Integer photo_no;
	private Integer review_no;
	private String photo_url;
	
	public AttachVO(Integer photo_no, Integer review_no) {
		super();
		this.photo_no = photo_no;
		this.review_no = review_no;
	}
}
