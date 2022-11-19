package springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("springDemoResource/applicationContext.xml");
        CricketCoach cricketCoach=context.getBean("myCricketCoach", CricketCoach.class);
        System.out.println(cricketCoach.getDailyFortune());
        System.out.println(cricketCoach.getDailyWorkout());
        System.out.println(cricketCoach.getEmailAdress());
        System.out.println(cricketCoach.getTeam());
        context.close();
    }
}
