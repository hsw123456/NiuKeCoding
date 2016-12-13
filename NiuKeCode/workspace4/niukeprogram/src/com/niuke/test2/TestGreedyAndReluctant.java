package com.niuke.test2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestGreedyAndReluctant {
	
	public static void main(String[] args) {
		Pattern p = Pattern.compile("(.{3,10}?)[0-9]");
		
		String s ="aaaa5bbbb6";
		Matcher m = p.matcher(s);
		
		if(m.find()){
			System.out.println(m.start() +"-"+m.end());
		}else {
			System.out.println("not matched");
		}
		
		System.out.println("Java".matches("(?i)java"));
		//p = Pattern.compile("java",Pattern.CASE_INSENSITIVE);
		

	}

}
