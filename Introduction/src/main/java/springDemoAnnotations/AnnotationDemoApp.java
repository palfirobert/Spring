package springDemoAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springDemo.Coach;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("springDemoAnnotationsResource/applicationContextAnnotations.xml");
        TennisCoach theCoach=context.getBean("tennisCoach",TennisCoach.class);
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.email);
        context.close();
    }
}
