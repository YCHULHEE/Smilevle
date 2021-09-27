package com.smilevle.review.model;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class ReviewPageVO {
	
	// 현재페이지, 시작페이지, 끝페이지, 게시글 총 갯수, 페이지당 글 갯수, 마지막페이지, SQL쿼리에 쓸 start, end
	private int pageNo, startPage, endPage, total, lastPage, start, end;
	private int cntPage = 5;
	private int cntPerPage = 9;
	
	public ReviewPageVO() {
	}
	public ReviewPageVO(int total, int pageNo) {
		setPageNo(pageNo);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getPageNo(), cntPage);
		calcStartEnd(getPageNo(), getCntPerPage());
	}
	// 제일 마지막 페이지 계산
	public void calcLastPage(int total, int cntPerPage) {
		setLastPage((int) Math.ceil((double)total / (double)cntPerPage));

	}
	// 시작, 끝 페이지 계산
	public void calcStartEndPage(int pageNo, int cntPage) {
		int modVal = pageNo % 5;
		setStartPage(pageNo / cntPage * cntPage + 1);
		if (modVal == 0) {
			setStartPage(pageNo / cntPage * cntPage + 1 - 5);
		}
		setEndPage(getStartPage() + 4);
		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
	}
	// DB 쿼리에서 사용할 start, end값 계산
	public void calcStartEnd(int pageNo, int cntPerPage) {
		setEnd(pageNo * cntPerPage);
		setStart(getEnd() - cntPerPage + 1);
	}
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCntPerPage() {
		return cntPerPage;
	}
	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}	
	public int setCntPage() {
		return cntPage;
	}
	public void getCntPage(int cntPage) {
		this.cntPage = cntPage;
	}
	
	public boolean hasNoReviews() {
		return total == 0;
	}
	
	public boolean hasReviews() {
		return total > 0;
	}	 
	
}
