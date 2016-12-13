package com.atguigu.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		/*//创建helloWorld 的一个对象
		HelloWorld h = new HelloWorld();
		//为name 属性赋值
		h.setName("atguigu");*/
		
		//1.创建spring 的IOc 容器对象
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2.从Ioc 中获取Bean 实例
		
		//HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloworld");
		
		
		//3.调用hello 方法；
		//helloWorld.hello();
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		
		car = (Car) ctx.getBean("car2");
		System.out.println(car);
		
		Person person = ctx.getBean(Person.class);
		System.out.println(person);
		
	}

}
