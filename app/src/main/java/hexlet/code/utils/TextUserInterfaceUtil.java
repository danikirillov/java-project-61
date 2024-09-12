package hexlet.code.utils;

import java.util.Scanner;

public final class TextUserInterfaceUtil {
    public static void congratulateUser(String name) {
        System.out.printf("Congratulations, %s!%n", name);
    }

    public static void printCorrectAnswerMessage() {
        System.out.println("Correct!");
    }

    public static void printWrongAnswerMessage(String answer, String correctAnswer, String name) {
        System.out.printf(
            "'%s' is wrong answer ;(. Correct answer was '%s'.%nLet's try again, %s!%n",
            answer,
            correctAnswer,
            name
        );
    }

    public static String getUserAnswer(String question) {
        var sc = new Scanner(System.in);
        System.out.printf("Question: %s%nYour answer: ", question);
        return sc.next();
    }
}
