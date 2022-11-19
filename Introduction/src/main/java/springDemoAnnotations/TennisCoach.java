package springDemoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import springDemo.Coach;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("tennisCoach") // id-ul default este asta, puteam scrie doar Component
@Scope("prototype")
public class TennisCoach implements Coach {

    @Value("${foo.email}")
    public String email;
    @Qualifier("sadFortuneService")
    @Autowired //field injection, si constructor si setter si field fac acelasi lucru
    private FortuneService fortuneService;


    public TennisCoach() {
        System.out.println("Inside default contructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("Item was created");
    }

    @PreDestroy
    public void destroyed() {
        System.out.println("Item was deleted");
    }

//Constructor injection
//    @Autowired
//    public TennisCoach(FortuneService fortuneService)
//    {
//        this.fortuneService=fortuneService;
//    }

//    @Autowired //constructor cu qualifier
//    public TennisCoach(@Qualifier("sadFortuneService") FortuneService fortuneService)
//    {
//        this.fortuneService=fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Let's go balling!";
    }

//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//
//        this.fortuneService = fortuneService;
//    }  // setter injection

    //        @Autowired
//        @Qualifier("sadFortuneService")
//    public void setFortuneService(FortuneService fortuneService) {
//
//        this.fortuneService = fortuneService;
//    }  // setter injection
    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
