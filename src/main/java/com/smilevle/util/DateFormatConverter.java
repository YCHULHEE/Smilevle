package com.smilevle.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatConverter {
	
	public static String convertDate(Date date) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dateStr = simpleDateFormat.format(date);
		return dateStr;
	}
}

	