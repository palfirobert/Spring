package springDemoAnnotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SadFortuneService implements FortuneService{

    private String[]data={"Today is your sad day!","Hello you are lucky","You are gay!"};
    @Override
    public String getFortune() {
        Random random=new Random();
        return data[random.nextInt(data.length)];
    }
}
