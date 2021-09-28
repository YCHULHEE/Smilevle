package com.smilevle;

import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		List list = new ArrayList();
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
