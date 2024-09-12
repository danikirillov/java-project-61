package hexlet.code.games;

import java.util.Scanner;
import java.util.StringJoiner;

import static hexlet.code.App.MAX_ROUNDS_AMOUNT;
import static hexlet.code.App.RANDOM;
import static hexlet.code.utils.TextUserInterfaceUtil.congratulateUser;
import static hexlet.code.utils.TextUserInterfaceUtil.printCorrectAnswerMessage;
import static hexlet.code.utils.TextUserInterfaceUtil.printWrongAnswerMessage;

public class Progression implements Game {

    @Override
    public void play(String username) {
        System.out.println("What number is missing in the progression?");

        var attempt = 0;
        var sc = new Scanner(System.in);

        while (attempt < MAX_ROUNDS_AMOUNT) {
            var first = RANDOM.nextInt(-30, 30);
            var step = RANDOM.nextInt(1, 30);
            var length = RANDOM.nextInt(5, 10);
            var position = RANDOM.nextInt(length);
            var progression = createProgression(first, step, length, position);

            System.out.printf("Question: %s%nYour answer: ", progression);

            var answer = sc.next();

            var correctAnswer = compute(first, step, position);
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
