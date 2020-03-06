package com.lzw.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面处理器
 */
@Aspect
@Component
public class MyAspect {

	/**
	 * 耗时切面处理
	 */
	// @Pointcut(value = "execution(public * com.lzw.service.MyService.*(..))")
	@Pointcut("@annotation(TimeAspect)")
	public void processTime() {
	}

	@Around("processTime()")
	public Object processTimeAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object proceed = proceedingJoinPoint.proceed();
		System.out.println("spent " + (System.currentTimeMillis() - startTime));
		return proceed;
	}

	@Pointcut("@annotation(ValidateAspect)")
	public void validate() {
	}

	@Around("validate()")
	public Object processValidateAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String classFullName = proceedingJoinPoint.getSignature().getDeclaringTypeName();
		return proceedingJoinPoint.proceed();
	}
}
