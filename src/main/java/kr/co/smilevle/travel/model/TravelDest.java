package kr.co.smilevle.travel.model;

import kr.co.smilevle.common.model.BaseInfo;

public class TravelDest implements BaseInfo {
	private String title;
	private String areaCode;
	private String address;
	private String firstImage;
	private int contentId;
	private int readCount;
	private String tel;
	private String mapX;
	private String mapY;
	private String contentTypeId;
	private String middleCategory;
	private String smallCategory;
	
	public TravelDest() {
	
	}
	public TravelDest(String contentTypeId, String title, String areaCode, String address, String firstImage, int contentId, int readCount,
			String tel, String mapX, String mapY) {
		super();
		this.title = title;
		this.areaCode = areaCode;
		this.address = address;
		this.firstImage = firstImage;
		this.contentId = contentId;
		this.readCount = readCount;
		this.tel = tel;
		this.mapX = mapX;
		this.mapY = mapY;
		this.contentTypeId = contentTypeId;
	}

	

	public TravelDest(String contentTypeId, String title, String areaCode, String address, String firstImage, int contentId, int readCount,
			String tel, String mapX, String mapY, String middleCategory, String smallCategory) {
		super();
		this.title = title;
		this.areaCode = areaCode;
		this.address = address;
		this.firstImage = firstImage;
		this.contentId = contentId;
		this.readCount = readCount;
		this.tel = tel;
		this.mapX = mapX;
		this.mapY = mapY;
		this.contentTypeId = contentTypeId;
		this.middleCategory = middleCategory;
		this.smallCategory = smallCategory;
	}

	public String getMiddleCategory() {
		return middleCategory;
	}

	public void setMiddleCategory(String middleCategory) {
		this.middleCategory = middleCategory;
	}

	public String getSmallCategory() {
		return smallCategory;
	}

	public void setSmallCategory(String smallCategory) {
		this.smallCategory = smallCategory;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFirstImage() {
		return firstImage;
	}
	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMapX() {
		return mapX;
	}
	public void setMapX(String mapX) {
		this.mapX = mapX;
	}
	public String getMapY() {
		return mapY;
	}
	public void setMapY(String mapY) {
		this.mapY = mapY;
	}

	public String getContentTypeId() {
		return contentTypeId;
	}

	public void setContentTypeId(String contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
}
