package com.niuke.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseSort {
	
	public static void main(String[] args) {
    	/*Scanner input = new Scanner(System.in);
		
		String str = null;
		List<String> list = new ArrayList<String>();
		System.out.println("please input a String(wanning ctrl+z 结束):");
		while(input.hasNext()){
			System.out.println("please input a String:");
			str = input.next();
			list.add(reverseSequence(str));
		}
		
		for(int i =0; i<list.size(); i++){
			System.out.println(list.get(i));
		}*/
		
		for(int i = 0; i<args.length;i++){
			System.out.println(reverseSequence(args[i]));
		}
		
	}
	
	public static String reverseSequence(String str){
		String str1 = "";
		for(int i = str.length()-1; i>=0; i--){
			str1 +=str.charAt(i);
		}
		
		return str1;
		
	}

}
