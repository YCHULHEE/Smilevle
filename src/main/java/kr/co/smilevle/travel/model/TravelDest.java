package kr.co.smilevle.travel.model;

public class TravelDest {
	private String contentId;
	private String title;
	private String areaCode;
	private String address;
	private String firstImage;
	private int readCount;
	private String tel;
	private String mapX;
	private String mapY;
	
	public TravelDest() {
	
	}
	public String getcontentId() {
		return contentId;
	}
	public void setcontentId(String contentId) {
		this.contentId = contentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getareaCode() {
		return areaCode;
	}
	public void setareaCode(String areaCode) {
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
	public TravelDest(String contentId, String title, String areaCode, String address, String firstImage, int readCount,
			String tel, String mapX, String mapY) {
		super();
		this.contentId = contentId;
		this.title = title;
		this.areaCode = areaCode;
		this.address = address;
		this.firstImage = firstImage;
		this.readCount = readCount;
		this.tel = tel;
		this.mapX = mapX;
		this.mapY = mapY;
	}
}
