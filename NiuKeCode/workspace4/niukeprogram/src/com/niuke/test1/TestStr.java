package com.niuke.test1;

import java.util.ArrayList;
import java.util.List;

public class TestStr {

	public static void main(String[] args) {
		String line = "10101";
		String subLine;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < line.length(); i++) {
			for (int j = i+1; j <= line.length(); j++) {
				subLine = line.substring(i, j);
				if (subLine.length() != line.length()) {
					System.out.println(subLine);
					list.add(subLine);
				}
			}
		}
		
		System.out.println(list);
	}

}
