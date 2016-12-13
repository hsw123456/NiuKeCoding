package com.atguigu.spring.beans.properties;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.beans.autowire.Address;
import com.atguigu.spring.beans.autowire.Person;

public class Client {
	
	public static void main(String[] args) throws Exception {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-properties.xml");
		
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		
		System.out.println(dataSource.getConnection());
		
	}

}
