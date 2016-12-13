package com.hsw.test2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestEvaluator {
	public static void main(String[] args) {
		
		String str;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Enter expression,1 per line");
			while((str = in.readLine())!= null){
				System.out.println("Read: " + str);
				Evaluator ev = new Evaluator(str);
				System.out.println(ev.getValue());
				System.out.println("Enter next expression");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
