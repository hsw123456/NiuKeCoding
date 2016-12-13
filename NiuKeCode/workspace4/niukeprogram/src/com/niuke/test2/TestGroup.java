package com.niuke.test2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestGroup {
	
	public static void main(String[] args) {
		
		String res = "i beleive i can fly do you think	so what are you Funking?";
		Pattern p = Pattern.compile("([a-zA-Z])(.*)");
		
		Matcher m = p.matcher(res);
		while(m.find()){
			System.out.println((char)(m.group(1).charAt(0)-32)+m.group(2));
		}
	}

}
