 package com.smilevle.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class TourVO {
	private String title;
	private String areaCode;
	private String address;
	private String firstImage;
	private int contentId;
	private int readCnt;
	private String tel;
	private String mapX;
	private String mapY;
	private String contentTypeId;
	private String middleCategory;
	private String smallCategory;
	private String content;
	private String homepage;
	private String imageList;
}
