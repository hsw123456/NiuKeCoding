package com.niuke.test;

import java.math.BigInteger;
import java.util.Scanner;

public class TestScanner {
	public static void main(String[] args) {
		
		int[] parameter = new int[5];
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i<5; i++){
			parameter[i] = scanner.nextInt();
		}
		
		int a0 =parameter[0];
		int a1 =parameter[1];
		int p =parameter[2];
		int q =parameter[3];
		int k =parameter[4];
			
		BigInteger[] arr = new BigInteger[k+1];
		arr[0] = new BigInteger(a0+"");
		arr[1] = new BigInteger(a1+"");
		
		
		for(int i =2; i<arr.length; i++ ){
			//arr[i] = p*arr[i-1] + q*arr[i-2];
			arr[i] = arr[i-1].multiply( new BigInteger(p+"") ).add(
					arr[i-2].multiply( new BigInteger(q+"") ));
		}
		
		for(int i = 0; i<arr.length;i++)	{
			System.out.println(arr[i]);
		}
		
		System.out.println(arr[k].mod(new BigInteger(10000+"")));
		
		
		
	}

}
