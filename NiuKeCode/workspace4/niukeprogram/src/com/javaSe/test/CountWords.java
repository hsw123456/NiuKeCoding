package com.javaSe.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountWords {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = "";
		List<String> list = new ArrayList<String>();
		while(in.hasNextLine()){
			line = in.nextLine();
			line = line.substring(0, line.length()-1);
			list.add(line);
		}
		
		for(String s: list){
			countWords(s);
		}
	}

	private static void countWords(String line) {
		String [] words = line.split(" +");
		for(int i=0;i<words.length;i++){
			System.out.print(words[i].length()+" ");
		}
		System.out.println();
	}

}
