package com.niuke.test2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestGreedy {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int maxTime = 0;
		int type = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] str = line.split(" ");
			try {
				maxTime = Integer.parseInt(str[0]);
				type = Integer.parseInt(str[1]);
			} catch (Exception e) {
				throw new RuntimeException("error");
			}
		}
		
		for (int i = 0; i < type; i++) {
			if(scanner.hasNextLine()){
				map.put(scanner.nextInt(), scanner.nextInt());
			}
		}
		

	}

	
}
