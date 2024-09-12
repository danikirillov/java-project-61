package hexlet.code.utils;

public class TextUserInterfaceUtil {
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
}
