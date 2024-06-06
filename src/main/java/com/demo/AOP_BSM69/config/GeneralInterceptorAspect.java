package com.demo.AOP_BSM69.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.demo.AOP_BSM69.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class GeneralInterceptorAspect {
	
	//within
	//@Pointcut("execution(* com.demo.AOP_BSM69.controller.*.*(..))")
	//@Pointcut("this(com.demo.AOP_BSM69.service.DepartmentService)")
	@Pointcut("@annotation(com.demo.AOP_BSM69.annotation.CustomAnnotation)")
	public void loggingPointCut() {
		
	}
	
//	@Before("loggingPointCut()")
//	public void before(JoinPoint joinPoint) {
//		System.out.println("Before method invoked: " + joinPoint.getSignature());
//	}
//	
//	@After("loggingPointCut()")
//	public void after(JoinPoint joinPoint) {
//		System.out.println("After method invoked: " + joinPoint.getSignature());
//	}
	
//	@AfterReturning(value = "execution(* com.demo.AOP_BSM69.controller.*.*(..))", returning = "employee")
//	public void after(JoinPoint joinpoint, Employee employee) {
//		System.out.println("After method invoked:: " + employee);
//	}
//	@AfterThrowing(value = "execution(* com.demo.AOP_BSM69.controller.*.*(..))", throwing = "e")
//	public void after(JoinPoint joinpoint, Exception e) {
//		System.out.println("After method invoked wuth Exception:: " + e.getMessage());
//	}
//	
	@AfterThrowing(value = "loggingPointCut()", throwing = "e")
	public void after(JoinPoint joinpoint, Exception e) {
		System.out.println("After method invoked wuth Exception:: " + e.getMessage());
	}
	
	@Around("loggingPointCut()")
	public Object around(ProceedingJoinPoint joinpoint) throws Throwable{
		System.out.println("Before Method invoked:: " + joinpoint.getArgs()[0]);
		Object object = joinpoint.proceed();
		if(object instanceof Employee) {
			System.out.println("After method invoked...Employee " + joinpoint.getArgs()[0]);
		}else {
			System.out.println("After method invoked... " + joinpoint.getArgs()[0]); //department endpoint
		}
		return object;
		
	}


}
