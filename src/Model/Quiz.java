package Model;
import java.util.*;

public class Quiz {
    private int finalScore;
    private Map<Integer, ArrayList<String>> feedbacks;
    private Map<Integer, List<Question>> questions;


    public Quiz() {
        questions = new HashMap<>();
        feedbacks = new HashMap<>();
        for (int i = 1; i <=5; i++) {
            feedbacks.put(i, new ArrayList<>());
            questions.put(i, new ArrayList<>());
        }
        this.finalScore = 0;
    }

    public ArrayList<String> getFeedBack(int level) {
        switch (level) {
            case 1: ArrayList<String> feedback1 = feedbacks.get(1);
                return feedback1;
            case 2:  ArrayList<String> feedback2  = feedbacks.get(2);
                return feedback2;
            case 3:  ArrayList<String> feedback3  = feedbacks.get(3);
                return feedback3;
            case 4: ArrayList<String> feedback4  = feedbacks.get(4);
                return feedback4;
            case 5 :  ArrayList<String> feedback5  = feedbacks.get(5);
                return feedback5;
            default: throw new NoSuchElementException(); // runtime exception
        }
        return retArray;
    }


    public void addQuestion(Question question) {
        switch (question.getLevel()) {
            case 1: questions.get(1).add(question);
                break;
            case 2: questions.get(2).add(question);
                break;
            case 3: questions.get(3).add(question);
                break;
            case 4: questions.get(4).add(question);
                break;
            case 5: questions.get(5).add(question);
                break;
        }
    }

    public Map<Integer, List<Question>> getQuestions() {
        return questions;
    }

    public Map<Integer, ArrayList<String>> getFeedback() {return feedbacks;}


    public int getFinalScore() {
        return finalScore;
    }

    public void incrementScore(int score) {
        finalScore += score;
    }
}


