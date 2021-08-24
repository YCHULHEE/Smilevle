package kr.co.smilevle.stay.model;

public class Stay {
	private String stayId;
	private String title;
	private String areaCode;
	private String address;
	private String firstImage;
	private int contentId;
	private int readCount;
	private String tel;
	private String mapX;
	private String mapY;
	
	
	public String getStayId() {
		return stayId;
	}
	public void setStayId(String stayId) {
		this.stayId = stayId;
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
	
	public Stay() {
		// TODO Auto-generated constructor stub
	}
	
	public Stay(String stayId, String title, String areaCode, String address, String firstImage, int contentId,
			int readCount, String tel, String mapX, String mapY) {
		super();
		this.stayId = stayId;
		this.title = title;
		this.areaCode = areaCode;
		this.address = address;
		this.firstImage = firstImage;
		this.contentId = contentId;
		this.readCount = readCount;
		this.tel = tel;
		this.mapX = mapX;
		this.mapY = mapY;
	}
	
	public Stay(String title, String areaCode, String address, String firstImage, int readCount) {
		super();
		this.title = title;
		this.areaCode = areaCode;
		this.address = address;
		this.firstImage = firstImage;
		this.readCount = readCount;
	}
	
}
