package com.smilevle.tour.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourVO {
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
}
