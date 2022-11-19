package springDemo;

public class CricketCoach implements Coach{
    private FortuneService fortuneService;
    private String emailAdress;
    private String team;

    public CricketCoach(){
        System.out.println("CricketCoach: inside constructor");
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "Get fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
