package hexlet.code.games;

import java.math.BigInteger;

import static hexlet.code.App.MAX_ROUNDS_AMOUNT;
import static hexlet.code.App.RANDOM;
import static hexlet.code.utils.TextUserInterfaceUtil.congratulateUser;
import static hexlet.code.utils.TextUserInterfaceUtil.getUserAnswer;
import static hexlet.code.utils.TextUserInterfaceUtil.printCorrectAnswerMessage;
import static hexlet.code.utils.TextUserInterfaceUtil.printWrongAnswerMessage;

public final class Gcd implements Game {
    private static final int GCD_LOWER_BOUND = 1;
    private static final int GCD_UPPER_BOUND = 8;
    private static final int RANDOM_NUMBER_BOUND = 13;

    @Override
    public void play(String username) {
        System.out.println("Find the greatest common divisor of given numbers.");

        var attempt = 0;

        while (attempt < MAX_ROUNDS_AMOUNT) {
            var possibleGcd = RANDOM.nextInt(GCD_LOWER_BOUND, GCD_UPPER_BOUND);
            var firstNumber = RANDOM.nextInt(RANDOM_NUMBER_BOUND) * possibleGcd;
            var secondNumber = RANDOM.nextInt(RANDOM_NUMBER_BOUND) * possibleGcd;
            var question = firstNumber + " " + secondNumber;
            var correctAnswer = compute(firstNumber, secondNumber);

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

    private String compute(int firstNumber, int secondNumber) {
        var bigFirst = BigInteger.valueOf(firstNumber);
        var bigSecond = BigInteger.valueOf(secondNumber);

        return bigFirst.gcd(bigSecond).toString();
    }

    @Override
    public String getName() {
        return "GCD";
    }
}
