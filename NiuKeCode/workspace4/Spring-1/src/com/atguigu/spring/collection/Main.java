package com.atguigu.spring.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Person person = (Person) ctx.getBean("person5");
		System.out.println(person);
		
		NewPerson np = ctx.getBean(NewPerson.class);
		//System.out.println(np);
		
		DataSource dataSource = ctx.getBean(DataSource.class);
		
		//System.out.println(dataSource.getProperties());
	}

}
