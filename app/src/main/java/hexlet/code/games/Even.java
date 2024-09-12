package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.App.MAX_ROUNDS_AMOUNT;
import static hexlet.code.App.RANDOM;
import static hexlet.code.utils.TextUserInterfaceUtil.congratulateUser;
import static hexlet.code.utils.TextUserInterfaceUtil.printCorrectAnswerMessage;
import static hexlet.code.utils.TextUserInterfaceUtil.printWrongAnswerMessage;

public final class Even implements Game {
    private static final int RANDOM_NUMBERS_BOUND = 100;

    @Override
    public void play(String username) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var attempt = 0;
        var sc = new Scanner(System.in);

        while (attempt < MAX_ROUNDS_AMOUNT) {
            var randomNumber = RANDOM.nextInt(RANDOM_NUMBERS_BOUND);
            System.out.printf("Question: %d%nYour answer: ", randomNumber);
            var answer = sc.next();

            var correctAnswer = compute(randomNumber);
            if (correctAnswer.equals(answer)) {
                printCorrectAnswerMessage();
                ++attempt;
            } else {
                printWrongAnswerMessage(answer, correctAnswer, username);
                return;
            }
        }

        congratulateUser(username);
    }

    private static String compute(int randomNumber) {
        return randomNumber % 2 == 0 ? "yes" : "no";
    }

    @Override
    public String getName() {
        return "Even";
    }

}
