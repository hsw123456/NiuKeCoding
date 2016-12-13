package com.javaSe.test;

import java.math.BigInteger;
import java.util.Scanner;

public class TestAdd2 {

	
		
		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			BigInteger a = BigInteger.ZERO;
			BigInteger b = BigInteger.ZERO;
			String str = "";
			while(s.hasNext()){
				str = s.next();
				a= str2BigInteger(str);
				str = s.next();
				b= str2BigInteger(str);
				
				System.out.println(a.add(b));
			}
		}

		private static BigInteger str2BigInteger(String str) {
			str = str.replaceAll(",", "");
			return new BigInteger(str);
		}

		

}
