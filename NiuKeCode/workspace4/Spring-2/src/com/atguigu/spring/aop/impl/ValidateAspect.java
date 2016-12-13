package com.atguigu.spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
 * 可以使用@order指定切面的优先级，值越小，优先级越高
 */
@Order(1)
@Aspect
@Component
public class ValidateAspect {
	
	
	@Before("com.atguigu.spring.aop.impl.LoggingAspect.declareJoinPointException()")
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("---validate:"+ Arrays.asList(joinPoint.getArgs()));
	}

}
