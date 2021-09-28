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
	private Integer reviewNo;
	private String writerId;
	private String writerName;
	private String title;
	private String areacode;
	private String locationName;
	private String rate;
	private String content;
	private Date regDate;
	private Date modDate;
	private int readCnt;
	private Integer contentId;
		
}
