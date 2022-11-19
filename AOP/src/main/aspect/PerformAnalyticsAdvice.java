package main.aspect;

import main.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class PerformAnalyticsAdvice {

    @Pointcut("execution(* add*(..))")
    private void forDaoPackage(){}
    @Pointcut("execution(* get*(..))")
    private void getter(){
    }

    @Pointcut("execution(* set*(..))")
    private void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){};;

    @Before("forDaoPackageNoGetterSetter()")
    public void performAnalyticsAdvice(JoinPoint joinPoint)
    {

        MethodSignature signature= (MethodSignature) joinPoint.getSignature();
        Object[] arguments=joinPoint.getArgs(); //aici se iau argumentele din metodele care se apeleaza
        for(Object o:arguments)
            System.out.println(o);
        System.out.println(signature);
    }
    @AfterReturning(pointcut = "execution(* main.dao.AccountDAO.findAccounts(..))",returning = "result")
    public void afterReturningAccounts(JoinPoint joinPoint, List<Account> result)
    {
        System.out.println(result);
        //aici se pot face si modificari la lista
    }

    @AfterThrowing(pointcut = "execution(* main.dao.AccountDAO.findAccounts(..))",throwing = "exception")
    public void ThrowingExceptionFindAccounts(JoinPoint joinPoint,Throwable exception)
    {
        System.out.println(exception);
    }

}
