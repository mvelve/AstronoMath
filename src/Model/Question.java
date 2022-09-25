package Model;
import java.util.ArrayList;
import java.util.List;

public class Question {
    private String description;
    private int level;
    protected int numAttempts;
    private Character correctAnswer;
    private List<Double> options = new ArrayList<>();
    private int currentAttempts;

    public Question (String description, Character answer, int level,
                     double optionA, double optionB, double optionC, double optionD ) {
        this.description = description;
        this.correctAnswer = answer;
        this.numAttempts = 3;
        this.currentAttempts = 0;
        this.level = level;
        options.add(optionA);
        options.add(optionB);
        options.add(optionC);
        options.add(optionD);
    }

    public String getDescription() {
        return description;
    }

    public int getCurrentAttempts() {
        return currentAttempts;
    }

    public void incrementCurrentAttempts() {
        currentAttempts++;
    }
    public int getLevel() {
        return level;
    }

    public int getNumAttempts() {
        return numAttempts;
    }

    public Character getCorrectAnswer() {
        return correctAnswer;
    }

    public List<Double> getOptions() {
        return options;
    }

    public void decrementAttempts() {
        numAttempts--;
    }


}


