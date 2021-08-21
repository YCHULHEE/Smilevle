package kr.co.smilevle.review.model;

import java.util.Date;

public class Review {
	private Integer number;
	private Writer writer;
	private String title;
	private int areacode;
	private String locationName;
	private double rate;
	private String content;
	private Date regDate;
	private Date modDate;
	private int readCount;
	
	public Review(Integer number, Writer writer, String title, int areacode, String locationName, double rate,
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

	public int getAreacode() {
		return areacode;
	}

	public String getLocationName() {
		return locationName;
	}

	public double getRate() {
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
