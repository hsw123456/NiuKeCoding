package com.niuke.test;

import java.util.Scanner;

public class CountTime {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a0,a1,p,k,q;
		int parameters[] = new int[5];
		for(int i = 0; i<5; i++){
			parameters [i] = input.nextInt(); 
		}
		
		a0 = parameters[0];
		a1 = parameters[1];
		p = parameters[2];
		k = parameters[3];
		q = parameters[4];
		
		int[] a = new int[k];
		a[0] = a0;
		a[1] = a1;
		
		System.out.println(a0);
		System.out.println(a1);
		System.out.println(p);
		System.out.println(k);
		System.out.println(q);
		
		/*for(int i = 2; i<k;i++){
			a[i] = p*a[i-1]+ q*a[i-2];
		}
		
		for(int i = 0; i<parameters.length;i++){
			System.out.println(parameters[i]);
		}
		
		*/
		
	}

}
