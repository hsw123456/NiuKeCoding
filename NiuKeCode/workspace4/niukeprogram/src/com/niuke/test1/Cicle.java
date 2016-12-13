package com.niuke.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cicle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		String a, b;
		for (int i = 0; i < count; i++) {
			a = toBinary(in.nextInt());
			b = toBinary(in.nextInt());
			if (isMatched(a, b)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static String toBinary(int num) {
		int m;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (num > 0) {
			m = num % 2;
			num = num / 2;
			list.add(m);
		}
		Collections.reverse(list);
		String str = "";
		for (int i = 0; i < list.size(); i++) {
			str += list.get(i);
		}

		return str;
	}

	public static boolean isMatched(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		if (len1 != len2) {
			if (len1 - len2 > 0) {
				for (int i = 0; i < len1 - len2; i++) {
					str2 = 0 + str2;
				}
			} else {
				for (int i = 0; i < len2 - len1; i++) {
					str1 = 0 + str1;
				}
			}
		}

		str1 += str1;
		int len = str1.length() / 2;
		for (int i = 0; i < len; i++) {
			if ((str1.substring(i, i + len)).equals(str2))
				return true;
		}

		return false;
	}

}
