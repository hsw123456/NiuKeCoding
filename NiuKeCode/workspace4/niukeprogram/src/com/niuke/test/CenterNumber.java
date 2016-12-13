package com.niuke.test;

import java.util.Scanner;

public class CenterNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			
			int N = input.nextInt();
			int arr[] = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = input.nextInt();
			}

			centerNumber(arr);
		}
	}

	public static void centerNumber(int[] num) {

		for (int p = 1; p < num.length; p++) {
			int temp = num[p];
			for (int j = p; j > 0; j--) {
				if (temp < num[j - 1]) {
					num[j] = num[j - 1];
					num[j - 1] = temp;
				}
			}
		}

		if (num.length % 2 == 0) {
			System.out
					.println( (num[num.length / 2] + num[num.length / 2 - 1]) / 2);
		} else {
			System.out.println( (num[num.length / 2]));
		}

	}

}
