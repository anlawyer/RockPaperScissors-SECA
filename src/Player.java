//import java.util.ArrayList;

public class Player {
//    public static ArrayList<String> history;
    private String name;
    private String play;
    int score;
    private String outcome;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
}
