package com.javaSe.test;

import java.math.BigInteger;
import java.util.Scanner;

public class TestAdd {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ZERO;
		
		while(s.hasNext()){
			a = new BigInteger(s.next());
			b= new BigInteger(s.next());
			
			System.out.println(a.add(b));
		}
	}

}
