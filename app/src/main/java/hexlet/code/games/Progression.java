package hexlet.code.games;

import java.util.StringJoiner;

import static hexlet.code.App.MAX_ROUNDS_AMOUNT;
import static hexlet.code.App.RANDOM;
import static hexlet.code.utils.TextUserInterfaceUtil.congratulateUser;
import static hexlet.code.utils.TextUserInterfaceUtil.getUserAnswer;
import static hexlet.code.utils.TextUserInterfaceUtil.printCorrectAnswerMessage;
import static hexlet.code.utils.TextUserInterfaceUtil.printWrongAnswerMessage;

public final class Progression implements Game {
    private static final int FIRST_NUMBER_LOWER_BOUND = -30;
    private static final int FIRST_NUMBER_UPPER_BOUND = 30;
    private static final int STEP_LOWER_BOUND = 1;
    private static final int STEP_UPPER_BOUND = 30;
    private static final int LENGTH_LOWER_BOUND = 5;
    private static final int LENGTH_UPPER_BOUND = 10;

    @Override
    public void play(String username) {
        System.out.println("What number is missing in the progression?");

        var attempt = 0;
        while (attempt < MAX_ROUNDS_AMOUNT) {
            var first = RANDOM.nextInt(FIRST_NUMBER_LOWER_BOUND, FIRST_NUMBER_UPPER_BOUND);
            var step = RANDOM.nextInt(STEP_LOWER_BOUND, STEP_UPPER_BOUND);
            var length = RANDOM.nextInt(LENGTH_LOWER_BOUND, LENGTH_UPPER_BOUND);
            var position = RANDOM.nextInt(length);
            var progression = createProgression(first, step, length, position);
            var correctAnswer = compute(first, step, position);

            var answer = getUserAnswer(progression);
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

    private String compute(int first, int step, int position) {
        var result = first + step * position;
        return String.valueOf(result);
    }

    private String createProgression(int first, int step, int length, int position) {
        var progression = new StringJoiner(" ");
        var number = first;
        for (int i = 0; i < length; ++i) {
            var currentNumber = position == i ? ".." : String.valueOf(number);
            progression.add(currentNumber);
            number += step;
        }
        return progression.toString();
    }

    @Override
    public String getName() {
        return "Progression";
    }
}
