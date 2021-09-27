package com.smilevle.corona.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoronaVO {
	private String coronaNo;
	private String areaCode;
	private int count;
	private String localName;
	private Date regDate;
}
