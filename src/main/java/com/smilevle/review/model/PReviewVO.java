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
	private String photoUrl;
	
	public PReviewVO(String writerId, String writerName, String title, String areacode, String locationName,
			String rate, String content, Date regDate, Date modDate, int readCnt, String photoUrl) {
		super();
		this.writerId = writerId;
		this.writerName = writerName;
		this.title = title;
		this.areacode = areacode;
		this.locationName = locationName;
		this.rate = rate;
		this.content = content;
		this.regDate = regDate;
		this.modDate = modDate;
		this.readCnt = readCnt;
		this.photoUrl = photoUrl;
	}
	
}
