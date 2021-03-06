package kr.co.smilevle.review.model;

import java.util.Date;

public class Review {
	private Integer number;
	private Writer writer;
	private String title;
	private String areacode;
	private String locationName;
	private String rate;
	private String content;
	private Date regDate;
	private Date modDate;
	private int readCount;
	
	public Review(Integer number, Writer writer, String title, String areacode, String locationName, String rate,
			String content, Date regDate, Date modDate, int readCount) {
		super();
		this.number = number;
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

	public Integer getNumber() {
		return number;
	}

	public Writer getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public String getAreacode() {
		return areacode;
	}

	public String getLocationName() {
		return locationName;
	}

	public String getRate() {
		return rate;
	}

	public String getContent() {
		return content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public int getReadCount() {
		return readCount;
	}
	
}
