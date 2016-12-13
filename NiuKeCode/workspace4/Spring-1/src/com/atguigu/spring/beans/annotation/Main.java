package com.atguigu.spring.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.beans.annotation.control.UserController;
import com.atguigu.spring.beans.annotation.repository.UserRepository;
import com.atguigu.spring.beans.annotation.service.UserService;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
//		
//		TestObject to = (TestObject) ctx.getBean("testObject");
//		System.out.println(to);
		
		UserController uc = (UserController) ctx.getBean("userController");
		uc.execute();
		//System.out.println(uc);
		
//		UserService us = (UserService) ctx.getBean("userService");
//		System.out.println(us);
//		
//		UserRepository urRepository = (UserRepository) ctx.getBean("userRepository");
//		System.out.println(urRepository);
	}

}
