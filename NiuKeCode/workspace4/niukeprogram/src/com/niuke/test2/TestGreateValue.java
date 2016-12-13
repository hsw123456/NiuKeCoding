package com.niuke.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestGreateValue{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int arrayCount = 0;
		if (s.hasNextInt()) {
			arrayCount = s.nextInt();
		}
		int[][] arrs = new int[arrayCount][];
		for (int i = 0; i < arrayCount; i++) {
			int N = 0;
			if (s.hasNextLine()) {
				N = s.nextInt();
			}

			int[] arr = new int[N];
			int k = 0;
			while (s.hasNextLine()) {
				if (k >= N)
					break;
				arr[k++] = s.nextInt();
			}

			arrs[i] = arr;
		}

		for (int i = 0; i < arrayCount; i++) {
			maxOrMin(arrs[i]);
			System.out.println();
		}

	}

	public static void maxOrMin(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
		if (arr[0] != arr[1])
			list.add(0);
		for (int i = 1; i < arr.length - 1; i++) {
			if ((arr[i] > arr[i - 1] && arr[i + 1] < arr[i])
					|| (arr[i] < arr[i - 1] && arr[i + 1] > arr[i])) {
				list.add(i);
			}
		}

		if (arr[arr.length - 1] != arr[arr.length - 2])
			list.add(arr.length-1);
		
		if(list.size() ==1)
			System.out.println(list.get(0));
		else {
			System.out.print(list.get(0));
			for(int i=1;i<list.size();i++){
				System.out.print(" "+list.get(i));
			}
		}
		
        
	}
}
