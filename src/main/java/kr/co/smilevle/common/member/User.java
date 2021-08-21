package kr.co.smilevle.common.member;

public class User {// 글 작성 테스트를 위한 임시 클래스
	
	private String id;
	private String name;
	
	public User(String id, String name) {
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