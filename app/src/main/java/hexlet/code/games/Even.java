package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Even {
    private static final Random RANDOM = new Random();

    public static void play(String name) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var threeInRow = 0;
        var sc = new Scanner(System.in);

        while (threeInRow != 3) {
            var randomNumber = RANDOM.nextInt(100);
            System.out.printf("Question: %d%nYour answer: ", randomNumber);
            var answer = sc.next();

            var correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";
            if (correctAnswer.equals(answer)) {
                printCorrectAnswerMessage();
                ++threeInRow;
            } else {
                printWrongAnswerMessage(answer, correctAnswer, name);
                threeInRow = 0;
            }
        }

        congratulateUser(name);

    }

    private static void congratulateUser(String name) {
        System.out.printf("Congratulations, %s!%n", name);
    }

    private static void printCorrectAnswerMessage() {
        System.out.println("Correct!");
    }

    private static void printWrongAnswerMessage(String answer, String correctAnswer, String name) {
        System.out.printf(
            "'%s' is wrong answer ;(. Correct answer was '%s'.%nLet's try again, %s!%n",
            answer,
            correctAnswer,
            name
        );
    }
}
