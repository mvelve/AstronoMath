package UI;

import Model.Question;
import Model.Quiz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuizConsole {
    private final Scanner input = new Scanner(System.in);
    private Quiz quiz;
    private static final String DESTINATION = "./data/constellations.json";
    private JsonReader reader = new JsonReader(DESTINATION);
    private JsonWriter writer = new JsonWriter(DESTINATION);


    private final String Aries = "                                        \n" +
            "Aries                                   \n" +
            "                                        \n" +
            "                                        \n" +
            "..   .'.......................;,.       \n" +
            "...  .,'...................   .,.       \n" +
            "..                             .'.      \n" +
            "                                .'.     \n" +
            "                                .'.     \n" +
            "                                 .'.    \n" +
            "                                  .'    \n" +
            "                                  .'.   \n" +
            "                                   .'.  \n" +
            "                                    ';. \n" +
            "                                   .,;. \n" +
            "                                  ....  \n" +
            "                                 .'.    \n" +
            "                                .,;.    \n" +
            "                              .';.      \n" +
            "                            .,,.        \n" +
            "                            .'.         \n" +
            "                                        \n" +
            "                                        \n";

    private final String ursaMajor = "                                        \n" +
            "Ursa Major                              \n" +
            "                                        \n" +
            "    . .. . .                            \n" +
            "            ..                          \n" +
            "              . .                       \n" +
            "                 ....                   \n" +
            "                     ...                \n" +
            "                     .. ..  .           \n" +
            "                     .        ..  .     \n" +
            "                   .'.           .      \n" +
            "                    .. .      ..        \n" +
            "                        . .  ..         \n" +
            "                                        \n" +
            "                                        \n" +
            "                                        \n";
    private final String ursaMinor =
            "Ursa Minor                              \n" +
                    "                                        \n" +
                    "                                        \n" +
                    "                                        \n" +
                    "                                        \n" +
                    "        ... ..  ...                     \n" +
                    "       .         ..                     \n" +
                    "     ..          ..                     \n" +
                    "     .. . .. . . ...                    \n" +
                    "                    . ...               \n" +
                    "                          ...  ..       \n" +
                    "                                  .     \n" +
                    "                                        \n" +
                    "                                        \n" +
                    "                                        \n";
    private final String cassiopeia =
            "Cassiopeia                              \n" +
                    "                                        \n" +
                    "                                        \n" +
                    "     .                                  \n" +
                    "      .                                 \n" +
                    "       .           ..                   \n" +
                    "        .    . . .. ,.                  \n" +
                    "         . ..         .         ..      \n" +
                    "         ..            .       ..       \n" +
                    "                        .    ..         \n" +
                    "                        .  .            \n" +
                    "                        ...             \n" +
                    "                        ..              \n" +
                    "                                        \n" +
                    "                                        \n" +
                    "                                        \n" +
                    "                                        \n";
    private final String aquila = "                                        \n" +
            "Aquila                                  \n" +
            "                                        \n" +
            "                                        \n" +
            "                              ..        \n" +
            "                              ..        \n" +
            "           . ..              .  .       \n" +
            "          ..    .           .   .       \n" +
            "         .       .          .   .       \n" +
            "                  ..       .    .       \n" +
            "                     .   ..     .       \n" +
            "                   .  . ..      .       \n" +
            "              . ..               .      \n" +
            "         . .                     .      \n" +
            "      . ...  ... .. .    .. .  ....     \n" +
            "                                ...     \n" +
            "                                        \n" +
            "                                        \n" +
            "                                        \n" +
            "                                        \n";


    private ArrayList<String> constellations = new ArrayList<>(Arrays.asList(Aries, ursaMajor, ursaMinor, cassiopeia, aquila));
    private ArrayList<String> unlockedConstellations = new ArrayList<>();


    public QuizConsole() {
        quiz = new Quiz();
        displayMenu();
        starNum = 0;
    }


    public void accessQuiz() {

    }

    public void displayMenu() {
        boolean keepDisplay = true;
        while (keepDisplay) {
            System.out.println("Option 1: Press t to take your quiz");
            System.out.println("Option 2: Press s to save your progress");
            System.out.println("Option 3: Press l to load your progress");
            System.out.println("Option 4: Press q to quit your program");
            switch (input.nextLine()) {
                case "t":
                    createQuiz();
                    initiateQuiz();
                    seeQuiz();
                    keepDisplay = false;
                    break;
                case "l" : loadConstellation();
                    break;
                case "s" : saveConstellation();
                    break;
                case "q":
                    keepDisplay = false;
                    System.out.println("You have exited the quiz");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select a valid menu option");
            }
        }
    }

    public void createQuiz() {
        ArrayList<String> feedbacks1 = quiz.getFeedBack(1);
        ArrayList<String> feedbacks2 = quiz.getFeedBack(2);
        ArrayList<String> feedbacks3 = quiz.getFeedBack(3);
        ArrayList<String> feedbacks4 = quiz.getFeedBack(4);
        ArrayList<String> feedbacks5 = quiz.getFeedBack(5);

        feedbacks1.add("Reach for the stars!");
        feedbacks1.add("Learn something new everyday!");
        feedbacks1.add("Mind over matter");
        feedbacks1.add("Keep working you got this!");
        feedbacks1.add("You can do it!");

        feedbacks2.add("To infinity and beyond!");
        feedbacks2.add("Think outside the box");
        feedbacks2.add("Always seek knowledge");
        feedbacks2.add("Everyday is a chance to learn");
        feedbacks2.add("Believe in yourself");

        feedbacks3.add("Be a unicorn in a field of horses!");
        feedbacks3.add("The expert in everything was once a beginner!");
        feedbacks3.add("You're amazing just the way you are!");
        feedbacks3.add("Do or do not there is no try");
        feedbacks3.add("Nothing is impossible");

        feedbacks4.add("Challenge yourself");
        feedbacks4.add("You make a choice with every action");
        feedbacks4.add("It is the courage that continues that counts");
        feedbacks4.add("You define your own life");
        feedbacks4.add("Never look back");

        feedbacks5.add("Believe you can and your halfway there");
        feedbacks5.add("You design yourself");
        feedbacks5.add("There is nothing more powerful then self-belief");
        feedbacks5.add("You make your own luck");
        feedbacks5.add("We are we do");

        quiz.addQuestion(new Question("What is 20 + 39", 'B', 2, 12.0, 59.0,
                58.0, 58.5));
        quiz.addQuestion(new Question("What is 70 + 10 + 8", 'C', 2, 68.0,
                80.0, 88.0, 9.0));
        quiz.addQuestion(new Question("What is 60 + 50 + 40", 'D', 2, 110.0, 90.0,
                98.0, 150.0));
        quiz.addQuestion(new Question("What is 300 - 77", 'A', 2, 221.0, 223.0,
                250.0, 200.0));
        quiz.addQuestion(new Question("What is 1900 - 600", 'A', 2, 1900.0,
                1850.0, 1825.0, 1875.0));


        quiz.addQuestion(new Question("What added to 21 and 53 is 138", 'A', 3, 60.0,
                62.0, 70.0, 71.0));
        quiz.addQuestion(new Question("71 + x + 85 = 194", 'B', 3, 50.0,
                38.0, 60.0, 40.0));
        quiz.addQuestion(new Question("71 + x + 85 = 194", 'B', 3, 50.0,
                38.0, 60.0, 40.0));
        quiz.addQuestion(new Question("1.3 + c = 8.8", 'C', 3, 8.0, 7.2,
                7.5, 8.2));
        quiz.addQuestion(new Question("1926 - x = 1009", 'D', 3, 915.0, 916.0,
                900.0, 917.0));


        quiz.addQuestion(new Question("What is 10 + 10?", 'D', 1, 17, 18,
                19, 20));
        quiz.addQuestion(new Question("What is 20 + 50?", 'C', 1, 50, 60,
                70, 80));
        quiz.addQuestion(new Question("What is 30 + 70?",
                'B', 1, 90, 100, 110, 120));
        quiz.addQuestion(new Question("What is 9 - 3?", 'B', 1, 7, 6, 5, 4));
        quiz.addQuestion(new Question("What is 20 - 2?", 'C', 1, 20, 19, 18, 17));

        quiz.addQuestion(new Question("What is 0.7 + 2.753?", 'A', 4, 3.453, 2.907,
                3.142, 2.913));
        quiz.addQuestion(new Question("What is 0.06 + 0.03?", 'C', 4, 0.07, 0.08, 0.09, 0.05));
        quiz.addQuestion(new Question("___ - 0.7 = 6.7",
                'A', 4, 7.4, 7.1, 7.9, 7.2));
        quiz.addQuestion(new Question("8.1 - ___ = 2.4?", 'D', 4, 5.6, 5.8, 5.9, 5.7));
        quiz.addQuestion(new Question("12 * 0.4 = ___", 'B', 4, 4.5, 4.8, 3.3, 4.9));


        quiz.addQuestion(new Question("94/100 = ___", 'D', 5, 0.93, 0.095, 0.93, 0.94));
        quiz.addQuestion(new Question("3/12 = ___", 'B', 5, 0.23, 0.25, 0.24, 0.2));
        quiz.addQuestion(new Question("25% of 44 = ___", 'D', 5, 16, 12, 13, 11));
        quiz.addQuestion(new Question("80% of 3 = ___", 'A', 5, 2.4, 1.2, 2.3, 2.5));
        quiz.addQuestion(new Question("55% of 50 = ___", 'A', 5, 27.5, 28.5, 29.3, 25.2));
    }

    // be careful because of the newline
    public void initiateQuiz() {
        boolean keepDisplay = true;
        while (keepDisplay) {
            System.out.println("Choose your level");
            System.out.println("1 for level 1 questions");
            System.out.println("2 for level 2 questions");
            System.out.println("3 for level 3 questions");
            System.out.println("4 for level 4 questions");
            System.out.println("5 for level 5 questions");

            String level = input.nextLine();

            switch (level) {
                case "1":
                    showQuestion(1);
                    keepDisplay = false;
                    break;
                case "2":
                    showQuestion(2);
                    keepDisplay = false;
                    break;
                case "3":
                    showQuestion(3);
                    keepDisplay = false;
                    break;
                case "4":
                    showQuestion(4);
                    keepDisplay = false;
                    break;
                case "5":
                    showQuestion(5);
                    keepDisplay = false;
                default:
                    System.out.println("Please choose a valid option!\nt");
            }
        }


    }

    public void showQuestion(int level) {
        for (Question q : quiz.getQuestions().get(level)) {
            System.out.println(q.getDescription());

            for (int i = 0; i < 4; i++) {
                System.out.println(((char) (i + 65)) + ": " + q.getOptions().get(i));
            }
            checkAnswer(q);
        }
    }

    public void displayEndingMenu() {
        boolean keepDisplay = true;
        while (keepDisplay) {
            System.out.println("Look up at the stars! You've unlocked a new constellation:");
            int randomConstellationNum = 1 + (int) (6 * Math.random()) / 2;
            String chosenConstellation = constellations.get(randomConstellationNum);
            if (starNum >= 5) {
                System.out.println(chosenConstellation);
                if (!unlockedConstellations.contains(chosenConstellation)) {
                    unlockedConstellations.add(chosenConstellation);
                }
            }

            System.out.println("Select from the following");
            System.out.println("b -> back to main menu");
            System.out.println("v -> view collection of constellations");

            String userinput = input.nextLine();

            switch (userinput) {
                case "b":
                    displayMenu(); // back to main menu
                    keepDisplay = false;
                    break;
                case "v":
                    viewConstellations();
                    keepDisplay = false;
                    break;
                default:
                    System.out.println("Please choose a valid option!\nt");

                    keepDisplay = false;
            }
        }
    }

    public void viewConstellations() {
        System.out.println("My Constellations:");
        for (String s: unlockedConstellations) {
            System.out.println(s);
        }
    }

    public void showFeedback(int level) {
        int randomValue = 1 + (int) (Math.random() * 10) / 2;
        Math.min(randomValue, 5); // just to be safe
        ArrayList<String> feedbacks = quiz.getFeedback().get(level);
        System.out.println(feedbacks.get(randomValue - 1));
    }

    public void checkAnswer(Question question) {
        ArrayList<Character> responseList = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D'));

        while (question.getNumAttempts() != 0) {
            Character answer = input.nextLine().charAt(0);
            if (!(responseList.contains(Character.toUpperCase(answer)))) {
                System.out.println("Please enter a valid option: A, B, C or D");
            } else if (question.getCorrectAnswer().equals(Character.toUpperCase(answer))) {
                quiz.incrementScore(question.getNumAttempts());
                System.out.println("You got it!!");
                System.out.println("A star has been added to the night sky!!");
                break;
            } else {
                question.incrementCurrentAttempts();
                question.decrementAttempts();
                if (question.getNumAttempts() == 0) {
                    System.out.println("You are out of attempts");
                    break;
                }
                showFeedback(question.getLevel());
                System.out.println("Please try again");
            }
        }
    }

    public void seeQuiz() {
        float score = quiz.getFinalScore();
        System.out.println("Your final score is " + score);
        System.out.println("You got approximately " + (score / 15) * 100 + "%");
//        System.out.println("You collected " + starNum + " stars!");
    }

    public void loadConstellation() {
        try {
            unlockedConstellations = reader.read();
            System.out.println("Loaded prior quiz" + " from " + DESTINATION);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + DESTINATION);
        }
    }

    public void saveConstellation() {
        try {
            writer.fileOpen();
            writer.writeTo(unlockedConstellations);
            writer.closeWriter();
            System.out.println("Your prior quiz has been saved in" + DESTINATION);

        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + DESTINATION);
        }
    }

}



