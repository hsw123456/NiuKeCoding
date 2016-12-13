package com.niuke.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ConvertSequence {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			BigInteger num = input.nextBigInteger();
			System.out.println(convertSequence(num));
		}
		
	}

	public static BigInteger convertSequence(BigInteger num) {
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		BigInteger base =new BigInteger("2");
		if (num.compareTo(zero)== 0)
			return zero;
		if (num.compareTo(one)==0)
			return one;

		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		BigInteger a = zero;
		while (num.compareTo(zero) >0) {
			a = num.mod(base);
			
			list.add(a);
			
			num = num.divide(base);
		}
		
		Collections.reverse(list);
		
		BigInteger sum = zero;
		for(int i= 0; i<list.size(); i++){
			sum = sum.add(list.get(i).multiply(base.pow(i)));
		}
		
		return sum;

	}

}
