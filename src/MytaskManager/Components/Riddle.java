
package MytaskManager.Components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Riddle {
     private String question;
    private String answer;

    public Riddle(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public static Riddle getRiddle() {
        List<Riddle> riddles = Riddle.getRiddles();
        Random random = new Random();
        int randomIndex = random.nextInt(riddles.size());
        return riddles.get(randomIndex);
    }
    
    public static List<Riddle> getRiddles() {
        List<Riddle> riddles = new ArrayList<>();
        riddles.add(new Riddle("What has keys but can't open locks?", "piano"));
        riddles.add(new Riddle("What has to be broken before you can use it?", "egg"));
        riddles.add(new Riddle("What gets wetter the more it dries?", "towel"));
        return riddles;
    }
}
