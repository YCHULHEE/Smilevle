package com.smilevle.tour.service;

import com.smilevle.tour.model.TourVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourData {
	private TourVO tourVO;
	private String[] imageList;
}
