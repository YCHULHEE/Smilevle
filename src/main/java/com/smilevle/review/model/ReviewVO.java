package com.smilevle.review.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewVO {
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
		
}
