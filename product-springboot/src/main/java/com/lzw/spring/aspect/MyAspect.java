package com.lzw.spring.aspect;

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

	@Around("processTime()") // 环绕
	// @Before("processTime()") // 方法处理之前
	// @After("processTime()") // 方法处理过后
	// @AfterReturning("processTime()") // 返回值为非void的时候
	// @AfterThrowing("processTime()") // 异常

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
