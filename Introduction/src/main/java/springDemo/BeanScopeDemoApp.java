package springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("springDemoResource/beanScopeContext.xml");

        Coach theCoach=context.getBean("myCoach",Coach.class);
        Coach alphaCoach=context.getBean("myCoach",Coach.class);

        System.out.println(theCoach.equals(alphaCoach));
        System.out.println(theCoach);
        System.out.println(alphaCoach);
        //scope prototype sa nu mai fie singleton
        context.close();
    }
}
