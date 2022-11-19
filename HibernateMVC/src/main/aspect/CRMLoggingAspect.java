package main.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    //setup logger
    private Logger logger=Logger.getLogger(getClass().getName());

    //setup Pointcut
    @Pointcut("execution(* main.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* main.dao.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* main.service.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
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
