package com.niuke.test1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSimpleDateFormat {
	
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		String start ="2016-10-2 19:22:53:313";
		long startTime;
		
		try {
			Date date = sdf.parse(start);
			System.out.println(date);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
