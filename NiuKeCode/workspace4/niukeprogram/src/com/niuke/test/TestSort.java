package com.niuke.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestSort {
	
	public static void main(String[] args) {
		
		System.out.println("please enter the number you need to sort:");
		
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		System.out.println("please input 0 or 1 0 means by desc 1 means by asc");
		
		int method = input.nextInt();
		
		//System.out.println("plesase enter students name and score");
		Scanner scanner = new Scanner(System.in);
		//String[] names = new String[num];
		//Integer[] scores = new Integer[num];
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//names[0] = scanner.next();
		//scores[0] = scanner.nextInt();
		for(int i = 0; i< num; i++){
			System.out.println("plesase enter students name and score");
			map.put(scanner.next(), scanner.nextInt());
		}
		scanner.close();
		List<Integer> values = new ArrayList<Integer>(map.values());
		List<String> sortedKeys = new ArrayList<String>();
		if(method == 1){
			 Collections.sort(values);
		}else{
			Collections.sort(values);
			Collections.reverse(values);
		}
		List<String> keys = new ArrayList<String>(map.keySet());
		for(Integer var: values){
			for(String str: keys){
				if(map.get(str).equals(var)){
					sortedKeys.add(str);
				}
			}
		}
		
		for(int i = 0; i<num; i++){
			System.out.print(sortedKeys.get(i)+" " + values.get(i));
			System.out.println();
		}
		
	}
	

}
