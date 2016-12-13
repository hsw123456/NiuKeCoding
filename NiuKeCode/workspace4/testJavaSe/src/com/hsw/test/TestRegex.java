package com.hsw.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	
	public static void main(String[] args) {
		//字符节点流
		try {
			FileReader fr = new FileReader(
					"C:\\Users\\Administrator\\Desktop\\email.html");
			
		//包装该节点流，使其成为处理流
		BufferedReader bfr = new BufferedReader(fr);
		String line ="";
		Pattern p= Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.\\w+");
		while((line=bfr.readLine()) != null) {
			Matcher m = p.matcher(line);
			while(m.find()){
				System.out.println(m.group());
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
