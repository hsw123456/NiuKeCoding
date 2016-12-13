package com.atguigu.spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class LoggingAspect {
	
	public void declareJoinPointException(){}
	

	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> argsList = Arrays.asList(joinPoint.getArgs());

		System.out.println("The method " + methodName + " begins with"
				+ argsList);
	}

	// 后置通知：在目标方法执行后（无论是否发生异常），执行的通知
	public void afterMethod(JoinPoint joinPoint) {

		String methodName = joinPoint.getSignature().getName();

		System.out.println("The method " + methodName + " ends ");
	}

	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();

		System.out.println("The method " + methodName + " ends " + result);
	}

	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();

		System.out.println("The method " + methodName
				+ " occurs with exception: " + ex.getMessage());
	}

	public Object aroundMethod(ProceedingJoinPoint pjb) {

		Object result = null;
		String methodName = pjb.getSignature().getName();
		// 执行目标方法
		try {
			// 前置通知
			System.out.println("The method " + methodName + "  begin with"
					+ Arrays.asList(pjb.getArgs()));
			result = pjb.proceed();

			// 后置通知
			System.out.println("The method  " + methodName + " ends with"
					+ result);

		} catch (Throwable e) {
			// 异常通知
			System.out.println("The method  " + methodName
					+ "  occurs exception:" + e);
			throw new RuntimeException(e);
		}
		// 后置通知
		System.out.println("The metod  " + methodName + "  ends..");
		return result;

	}

}
