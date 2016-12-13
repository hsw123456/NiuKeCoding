package com.niuke.test2;

import java.util.Scanner;

public class TestSplit {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String res="";
		while (input.hasNextLine()) {
			res = input.nextLine();
			output(res);
		}
		input.close();
	}

	public static void output(String res) {
		String[] afterSplit = res.split("\\s");
		String newRes = "";

		for (int i = 0; i < afterSplit.length; i++) {
			String a = "";
			char first = afterSplit[i].charAt(0);
			if (first >= 'a' && 'z' >= first) {
				for (int j = 1; j < afterSplit[i].length(); j++)
					a += afterSplit[i].charAt(j);
				a = (char) (first - 32) + a;
				afterSplit[i] = a;
			}

			
		}

		for (int k = 0; k < afterSplit.length; k++) {
			newRes += afterSplit[k] + " ";
		}

		System.out.println(newRes);
	}

}
