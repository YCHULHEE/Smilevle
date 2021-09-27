package com.smilevle.reservation.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationVO {
	private int resNum;
	private String contentId;
	private String memberId;
	private Date regDate;
	private String checkInDate;
	private String checkOutDate;	
	private String roomNum;
	private String title;

}
