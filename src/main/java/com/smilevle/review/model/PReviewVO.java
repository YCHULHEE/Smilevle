package com.smilevle.review.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PReviewVO {
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
	private String photoUrl;
	
	public PReviewVO(WriterVO writer, String title, String areacode, String locationName, String rate, String content,
			Date regDate, Date modDate, int readCount, String photoUrl) {
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
		this.photoUrl = photoUrl;
	}

}
