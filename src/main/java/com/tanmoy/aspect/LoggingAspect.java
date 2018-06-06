package com.tanmoy.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	// Add logging using log4j
	final static Logger logger = Logger.getLogger(LoggingAspect.class);

	@Pointcut("execution(* com.tanmoy.service.CalculateSomething.makeMyCalculation(..))")
	public void myPointcut() {
	}

	@Before("myPointcut()")
	public void logBefore(JoinPoint joinPoint) {
		logger.debug("**Before Advice: Before entering " + joinPoint.getSignature().getName() + "()  method");
	}

	@After("myPointcut()")
	public void logAfter(JoinPoint joinPoint) {
		logger.debug("**After Advice: Afer executing " + joinPoint.getSignature().getName() + "()  method");
	}

	@AfterReturning(pointcut = "execution(* com.tanmoy.service.CalculateSomething.returnSomeValue(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		logger.debug("**AfterReturning Advice: Method " + joinPoint.getSignature().getName() + "() returned value is " + result);
	}

	@AfterThrowing(pointcut = "execution(* com.tanmoy.service.CalculateSomething.throwSomeException(..))", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		logger.debug("**AfterThrowing Advice: Method " + joinPoint.getSignature().getName() + "() has thrown an exception: " + error);
	}

	@Around("execution(* com.tanmoy.service.CalculateSomething.makeSomeOtherCalculation(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			logger.debug("**Around Advice Starts**");
			logger.debug("Before entering " + joinPoint.getSignature().getName() + "()  method");
			joinPoint.proceed();
			logger.debug("Afer executing " + joinPoint.getSignature().getName() + "()  method"); //If the joinpoint does not throw any exception, then this line will be executed
			logger.debug("**Around Advice Ends**");
		} catch (Exception e) {
			logger.debug("Afer throwing exception " + e + " in " + joinPoint.getSignature().getName() + "()  method");//If the joinpoint throws an exception, then this line will be executed
			logger.debug("**Around Advice Ends**");
		}
	}
}