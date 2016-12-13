package com.niuke.test2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String out = "";
		while (s.hasNextLine()) {
			String res = s.nextLine();
			res = res.trim();

			char[] arr = res.toCharArray();
			Arrays.sort(arr);
			for(int i =0; i<arr.length;i++){
				out +=arr[i];
			}
			System.out.println(out);
			out="";
		}
	}

}
