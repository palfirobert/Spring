package springDemoAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScope {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("springDemoAnnotationsResource/applicationContextAnnotations.xml");
        TennisCoach coach1=context.getBean("tennisCoach",TennisCoach.class);
        TennisCoach coach2=context.getBean("tennisCoach",TennisCoach.class);
        System.out.println(coach1);
        System.out.println(coach2);
        context.close();


    }
}
