package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmilevleApplicationTests {

	@Test
	void contextLoads() {
		List list = new ArrayList<>();
		String checkInStr = "2021-09-29";
		String[] str1 = checkInStr.split("-");
		int[] yearMonthDay = new int[3];
 		
		
		for(int k = 0; k < 3; k++) {
			yearMonthDay[k] = Integer.parseInt(str1[k]);
		}
		
		
		for(int i : yearMonthDay) {
			System.out.println(i);
		}
		
	}	
}
