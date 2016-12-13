package com.atguigu.spring.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		//1.创建spring 的Ioc 容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		
		
		//2.从IOC 容器中获取Bean 的实例
		ArithmeticCalculater calculater = ctx.getBean(ArithmeticCalculater.class);
		//3.使用Bean
		//int result = calculater.add(3, 6);
		//System.out.println("result:"+ result);
		int  result = calculater.div(1000, 10);
		System.out.println("result:"+ result);
	}

}
