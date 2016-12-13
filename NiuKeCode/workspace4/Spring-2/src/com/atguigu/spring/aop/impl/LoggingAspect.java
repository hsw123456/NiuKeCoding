package com.atguigu.spring.aop.impl;

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

//把这个类声明为一个切面：1.需要放入IOC 容器中，再声明为一个切面
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	
	/*
	 * 定义一个方法用于声明切入点表达式，一般的该方法不需要任何代码
	 * 使用@Pointcut来声明切入点表达式
	 */
	@Pointcut("execution(* com.atguigu.spring.aop.impl.*.*(..))")
	public void declareJoinPointException(){}

	// 声明该方法是一个前置通知，在目标方法开始之前执行
	@Before("declareJoinPointException()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> argsList = Arrays.asList(joinPoint.getArgs());

		System.out.println("The method " + methodName + " begins with"
				+ argsList);
	}

	// 后置通知：在目标方法执行后（无论是否发生异常），执行的通知
	@After("declareJoinPointException()")
	public void afterMethod(JoinPoint joinPoint) {

		String methodName = joinPoint.getSignature().getName();

		System.out.println("The method " + methodName + " ends ");
	}

	/*
	 * 返回通知：在方法正常结束执行的代码 返回通知是可以访问到方法的返回值的
	 */
	@AfterReturning(value = "declareJoinPointException()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();

		System.out.println("The method " + methodName + " ends " + result);
	}

	/*
	 * 在目标方法出现异常时执行的代码， 可以访问到异常对象；且可以指定在出现特定异常时执行代码
	 */
	@AfterThrowing(value = "declareJoinPointException()", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();

		System.out.println("The method " + methodName
				+ " occurs with exception: " + ex.getMessage());
	}

	/*
	 * 环绕通知需要携带ProceedingJoinPoint的参数
	 * 类似于动态代理的全过程:ProceedingJoinPoint这个类型的参数可以决定是否执行目标方法
	 * 且环绕通知必须有返回值，返回值即为目标方法的返回值
	 */
	@Around("declareJoinPointException()")
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
