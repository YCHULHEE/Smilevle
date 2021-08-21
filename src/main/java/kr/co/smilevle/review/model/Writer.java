package kr.co.smilevle.review.model;

public class Writer {// 리뷰 작성자의 정보를 담을 자바빈 클래스
	private String id;
	private String name;
	
	public Writer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}
