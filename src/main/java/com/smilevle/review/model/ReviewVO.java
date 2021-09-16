package com.smilevle.review.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVO {
	private Integer number;
	private WriterVO writer;
	private String title;
	private String areacode;
	private String locationName;
	private String rate;
	private String content;
	private Date regDate;
	private Date modDate;
	private int readCount;
	
	public ReviewVO(WriterVO writer, String title, String areacode, String locationName, String rate, String content,
			Date regDate, Date modDate, int readCount) {
		super();
		this.writer = writer;
		this.title = title;
		this.areacode = areacode;
		this.locationName = locationName;
		this.rate = rate;
		this.content = content;
		this.regDate = regDate;
		this.modDate = modDate;
		this.readCount = readCount;
	}
	
	
}
