package com.webusermanagement.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class Logging {

    private Logger logger=Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.webusermanagement.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.webusermanagement.dao.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.webusermanagement.service.*.*(..))")
    private void forDAOPackage(){}
    @Pointcut("execution(* com.webusermanagement.controller.UserController.listEmployees())")
    private void method(){}
    @Pointcut("(forControllerPackage() || forServicePackage() || forDAOPackage()) && !method()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint)
    {
        String method=joinPoint.getSignature().toShortString();
        logger.info("======>> in @Before: calling method "+method);
        Object[]arguments= joinPoint.getArgs();
        for(Object o:arguments)
            logger.info(o.toString());
    }


    @AfterReturning(pointcut = "forAppFlow()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result)
    {
        String method=joinPoint.getSignature().toShortString();
        logger.info("======> in @AfterReturning: calling method "+method);
        logger.info("======> result: "+result);
    }
}
