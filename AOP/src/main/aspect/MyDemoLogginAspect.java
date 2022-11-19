package main.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLogginAspect {

    //@Before("execution(public void addAccount())") -toate add account-urile din main
    //@Before("execution(public void main.dao.AccountDAO.addAccount())") - specific
    //@Before("execution(public void add*())") //orice metoda ce incepe cu add
    //@Before("execution(public * addAccount())") //orice tip
    //@Before("execution(* add*(main.entity.Account))") -un parametru
    //@Before("execution(* add*(main.entity.Account,..))")

    //declarare de path in caz de reuse mult
    @Pointcut("execution(* add*(..))")
    private void forDaoPackage(){}
    @Pointcut("execution(* get*(..))")
    private void getter(){
    }

    @Pointcut("execution(* set*(..))")
    private void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){};


    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccount()
    {
        System.out.println("Executing before add account");
    }



}
