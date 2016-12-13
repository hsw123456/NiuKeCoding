package com.niuke.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RemoveDuplicate {
	
	
	public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			int N = input.nextInt();
			int[] arr = new int[N];
			for(int i =0; i<N; i++){
				arr[i]= input.nextInt();
			}
			
			removeduplicate(arr);
			
			String str = "abc";
			System.out.printf("%-8s",str);
	}

	public static void removeduplicate(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<arr.length;i++){
			if(list.contains(arr[i]))
				continue;
			list.add(arr[i]);
		}
		
		//Collections.sort(list);
		Object[] objects = list.toArray();
		Arrays.sort(objects);
		for(int i=0; i<objects.length;i++){
			System.out.println(objects[i]);
		}
		
	}
}
