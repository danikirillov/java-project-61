package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.App.MAX_ROUNDS_AMOUNT;
import static hexlet.code.App.RANDOM;
import static hexlet.code.utils.TextUserInterfaceUtil.congratulateUser;
import static hexlet.code.utils.TextUserInterfaceUtil.printCorrectAnswerMessage;
import static hexlet.code.utils.TextUserInterfaceUtil.printWrongAnswerMessage;

public class Even implements Game {

    @Override
    public void play(String username) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var attempt = 0;
        var sc = new Scanner(System.in);

        while (attempt < MAX_ROUNDS_AMOUNT) {
            var randomNumber = RANDOM.nextInt(100);
            System.out.printf("Question: %d%nYour answer: ", randomNumber);
            var answer = sc.next();

            var correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";
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

    @Override
    public String getName() {
        return "Even";
    }

}
