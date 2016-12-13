package com.atguigu.spring.aop.helloworld;

public class Client {
	
	public static void main(String[] args) {
		
		ArithmeticCalculater calculater = new ArithmeticCalculaterLoggingImpl();
		
		int result = calculater.add(1, 2);
		System.out.println(result);
		
		result = calculater.div(4, 2);
		System.out.println(result);
		
	}

}
