package com.niuke.test1;

import java.util.Scanner;

public class TestScanner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		while(scanner.hasNext()){
			System.out.println(scanner.next()+"-->"+ scanner.next());
		}
	}

}
