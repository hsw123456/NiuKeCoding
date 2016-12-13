package com.niuke.test;

import java.util.Scanner;

import com.sun.accessibility.internal.resources.accessibility;

public class ApproximateNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = input.nextInt();
		}
		
		printApproximateCount(arr);
		

	}

	public static void printApproximateCount(int[] num) {
		for (int i = 0; i < num.length; i++) {
			int count = 0;

			for (int j = 2; j <= num[i]/2; j++) {
				if (num[i] % j == 0) {
					count++;
				}
			}
			if(num[i] == 1)
				System.out.println(1);
			else {
				System.out.println(count+2);
			}
				
		}
	}
	
	public static int centerNumber(int[] num){
		
		for(int p=1;p<num.length; p++){
				int temp = num[p];
				for(int j= p; j>0;j--){
					if(temp< num[j-1]){
						num[j]= num[j-1] ;
						num[j-1]= temp;
					}
				}
		}
		
		if(num.length%2==0){
			return (num[num.length/2]+num[num.length/2-1])/2;
		}else {
			return (num[num.length/2]);
		}
		
	}

}
