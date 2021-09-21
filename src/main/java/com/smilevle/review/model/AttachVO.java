package com.smilevle.review.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachVO {
	private Integer photo_no;
	private Integer review_no;
	private String photo_url;
}
