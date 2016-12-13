package com.niuke.test;

public class TestString {
	
	public static void main(String[] args) {
		String str = "abcd";
		
		String str1 = str;
		
		for(int i = 0; i<str.length(); i++){
			String regex = String.valueOf(str.charAt(i));
			String replace = String.valueOf((char)(str.charAt(i)+ 1));
			str = str.replaceAll(regex, replace );
		}
		
		System.out.println(str);
	}

}
