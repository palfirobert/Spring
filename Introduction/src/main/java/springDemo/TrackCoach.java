package springDemo;

public class TrackCoach implements Coach{
    private FortuneService fortuneService;

    public TrackCoach(){}
    public TrackCoach(FortuneService theFortuneService)
    {
        this.fortuneService=theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just Do It: "+fortuneService.getFortune();
    }

    public void initMethod()
    {
        System.out.println("The bean "+this+" was created");
    }
    public void destroyMethod()
    {
        System.out.println("The bean "+this+" was destroyed");
    }
}
