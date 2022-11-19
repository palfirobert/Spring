package springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("springDemoResource/beanLifeCycleConfig.xml");

        Coach theCoach=context.getBean("myCoach",Coach.class);



        // trebuie sa fie singleton sa mearga
        context.close();
    }
}
