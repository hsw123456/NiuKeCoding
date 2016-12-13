package com.javaSe.test;

import java.util.Scanner;

public class FindIpAddress {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = 0;
		if(s.hasNextInt()){
			 N= s.nextInt();
		}
		for(int i=0 ;i<N;i++){
			if(s.hasNext()){
				isIP2(s.next());
			}
		}
	}

	private static void isIp(String ip) {
		String regex = "^(?:(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}"+
				"(?:(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))$";
		if(ip.matches(regex)){
			System.out.println("YES!");
		}else{
			System.out.println("NO!");
		}
	}
	
	private static void isIP2(String ip){
		String regex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
		if(ip.matches(regex)){
			String[] a = ip.split("\\.");
			String current = "";
			boolean flag = false;
			for(int i=0; i<a.length;i++){
				current = a[i];
				if(0>Integer.valueOf(current)||Integer.valueOf(current)>255){
					flag = true;
					break;
				}
			}
			
			if(flag){
				System.out.println("No!");
			}else{
				System.out.println("Yes!");
			}
			
		}else{
			System.out.println("No!");
		}
	}

}
