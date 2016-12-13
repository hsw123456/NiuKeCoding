package com.hsw.test;

import java.util.HashMap;

public class TestHashMap {
	
	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", null);
		map.put("name", "jack");
		map.put(null,"jack");
		
		System.out.println(map.size());
		
		String a ="136.9";
		String b ="136.95";
		
		System.out.println(a.compareTo(b));
	}

}
