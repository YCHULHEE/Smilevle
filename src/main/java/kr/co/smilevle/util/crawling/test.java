package kr.co.smilevle.util.crawling;


public class test {
	public static void main(String[] args) {
		String title = "피카소호텔 (강원)";

		
		if(title.indexOf("(", 2) != -1) {
			title = title.substring(0, title.indexOf("(", 2));
		}
		
		System.out.println(title);
	}
}	
