package kr.co.smilevle.stay.model;

public class Stay {
	private String contentid;
	private String title;
	private String areacode;
	private String address;
	private String firstImage;
	private String secondImage;
	private int readCount;
	private String tel;
	private String mapX;
	private String mapY;
	
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
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
	public String getSecondImage() {
		return secondImage;
	}
	public void setSecondImage(String secondImage) {
		this.secondImage = secondImage;
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
	
	public Stay(String title, String areacode, String address, String firstImage, int readCount) {
		super();
		this.title = title;
		this.areacode = areacode;
		this.address = address;
		this.firstImage = firstImage;
		this.readCount = readCount;
	}
}
