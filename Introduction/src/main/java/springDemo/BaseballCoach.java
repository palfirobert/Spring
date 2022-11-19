package springDemo;

public class BaseballCoach implements Coach{
    private FortuneService fortuneService;
    public BaseballCoach(){}
    public BaseballCoach(FortuneService theFortuneService)
    {
        this.fortuneService=theFortuneService;
    }
    @Override
    public String getDailyWorkout()
    {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
