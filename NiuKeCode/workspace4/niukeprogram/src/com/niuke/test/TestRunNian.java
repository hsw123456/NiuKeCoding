package com.niuke.test;

import java.util.Scanner;

public class TestRunNian {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year, month,day;
		while(input.hasNextInt()){
			year = input.nextInt();
			month = input.nextInt();
			day = input.nextInt();
			
			int numbers = countDay(year,month,day);
			System.out.println(numbers);
		}
	}

	private static int countDay(int year, int month, int day) {
		int[] monthlyday =new int[]{31,28,31,30,31,30,
										31,31,30,31,30,31}; 
		if((year%4==0&&year%100!=0)||(year%400==0)){
			monthlyday[1] = 29;
		}
		
		int sum = 0;
		for(int i= 0;i<month-1;i++){
			sum += monthlyday[i];
		}
		
		return sum+day;
	}

}
