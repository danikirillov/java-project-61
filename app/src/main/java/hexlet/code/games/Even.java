package hexlet.code.games;

import static hexlet.code.App.MAX_ROUNDS_AMOUNT;
import static hexlet.code.App.RANDOM;
import static hexlet.code.utils.TextUserInterfaceUtil.congratulateUser;
import static hexlet.code.utils.TextUserInterfaceUtil.getUserAnswer;
import static hexlet.code.utils.TextUserInterfaceUtil.printCorrectAnswerMessage;
import static hexlet.code.utils.TextUserInterfaceUtil.printWrongAnswerMessage;

public final class Even implements Game {
    private static final int RANDOM_NUMBERS_BOUND = 100;

    @Override
    public void play(String username) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var attempt = 0;
        while (attempt < MAX_ROUNDS_AMOUNT) {
            var randomNumber = RANDOM.nextInt(RANDOM_NUMBERS_BOUND);
            var question = String.valueOf(randomNumber);
            var correctAnswer = compute(randomNumber);

            var answer = getUserAnswer(question);
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
