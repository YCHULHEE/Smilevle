package com.smilevle.review.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewPageVO {
	// 현재 페이지
	private int pageNum;
	// 페이지당 수량
	private int pageSize;
	// 현재 페이지 수
	private int size;
	// 현재 페이지의 첫 번째 요소가 데이터베이스에 있는 줄 번호
	private long startRow;
	// 현재 페이지의 마지막 요소가 데이터베이스에 있는 줄 번호
	private long endRow;
	// 전체 페이지 수
	private int pages;
	// 이전 페이지
	private int prePage;
	// 다음 페이지
	private int nextPage;
	// 첫 페이지인지 여부
	private boolean isFirstPage = false;
	// 마지막 페이지인지 여부
	private boolean isLastPage = false;
	// 이전 페이지가 있는지 여부
	private boolean hasPreviousPage = false;
	// 다음 페이지가 있는지 여부
	private boolean hasNextPage = false;
	// 내비게이션 페이지 번호
	private int navigatePages;
	// 모든 내비게이션 페이지 번호
	private int [ ] navigatepageNums;
	// 내비게이션 바의 첫 페이지
	private int navigateFirstPage;
	// 내비게이션 바의 마지막 페이지
	private int navigateLastPage;
}
