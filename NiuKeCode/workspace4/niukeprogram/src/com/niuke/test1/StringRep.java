package com.niuke.test1;

import java.util.Scanner;

public class StringRep {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()) {
			String str = input.nextLine();
			String orginal = input.nextLine();
			   orginal = "\\b"+orginal+"\\b";
			String replace = input.nextLine();

			System.out.println(replaceWords(str, orginal, replace));

		}

	}
	
	
	
	public static String replaceWords(String str, String res, String rep) {
		str = str.replaceAll(res, rep);
		return str;
	}

}
