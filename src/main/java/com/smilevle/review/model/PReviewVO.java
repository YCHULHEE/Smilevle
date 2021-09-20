package com.smilevle.review.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PReviewVO {
	private Integer review_no;
	private String writer_id;
	private String writer_name;
	private String title;
	private String areacode;
	private String location_name;
	private String rate;
	private String content;
	private Date regDate;
	private Date modDate;
	private int readCnt;
	private String photo_url;
		
}
