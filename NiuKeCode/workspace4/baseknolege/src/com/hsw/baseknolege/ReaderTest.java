package com.hsw.baseknolege;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReaderTest {
	
	public static void main(String[] args)throws FileNotFoundException {
		
		Scanner input = new Scanner(new File(
				"E:\\Users\\Administrator\\workspace4\\baseknolege\\src\\numbers.dat"));
		double sum = 0.0;
		
		for(int i = 1; i<6; i++){
			double next = input.nextDouble();
			System.out.println("number" + i+ "=" + next);
			sum += next;
		}
		
		System.out.println("Sum = "+ sum);
		System.out.println();
		showSum();
	}
	
	public static void  showSum()throws FileNotFoundException {
		Scanner input = new Scanner(new File(
				"E:\\Users\\Administrator\\workspace4\\baseknolege\\src\\numbers.dat"));
		
		int count = 0;
		double sum = 0.0 ;
		while(input.hasNextDouble()){
			double next = input.nextDouble();
			count++;
			System.out.println("number" + count+ "=" + next);
			sum += next;
		}
		
		System.out.println("Sum = "+ sum);
		System.out.println("该文件共有 "+ count +"个数");
		
	}

}
