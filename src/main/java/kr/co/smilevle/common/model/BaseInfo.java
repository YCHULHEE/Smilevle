package kr.co.smilevle.common.model;

public interface BaseInfo {
	public String getContentTypeId();
	public void setContentTypeId(String contentTypeId);
	public int getContentId();
	public void setContentId(int contentId);
	public String getTitle();
	public void setTitle(String title);
	public String getAreaCode();
	public void setAreaCode(String areaCode);
	public String getAddress();
	public void setAddress(String address);
	public String getFirstImage();
	public void setFirstImage(String firstImage);
	public int getReadCount();
	public void setReadCount(int readCount);
	public String getTel();
	public void setTel(String tel);
	public String getMapX();
	public void setMapX(String mapX);
	public String getMapY();
	public void setMapY(String mapY);
	public String getMiddleCategory();
	public void setMiddleCategory(String middleCategory);
	public String getSmallCategory();
	public void setSmallCategory(String smallCategory);
}
