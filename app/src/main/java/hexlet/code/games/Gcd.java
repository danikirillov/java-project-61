package hexlet.code.games;

import hexlet.code.QnA;

import java.math.BigInteger;

import static hexlet.code.App.RANDOM;

public final class Gcd implements Game {
    private static final int GCD_LOWER_BOUND = 1;
    private static final int GCD_UPPER_BOUND = 8;
    private static final int RANDOM_NUMBER_BOUND = 13;

    @Override
    public String getDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public QnA getQuestionAndAnswer() {
        var possibleGcd = RANDOM.nextInt(GCD_LOWER_BOUND, GCD_UPPER_BOUND);
        var firstNumber = RANDOM.nextInt(RANDOM_NUMBER_BOUND) * possibleGcd;
        var secondNumber = RANDOM.nextInt(RANDOM_NUMBER_BOUND) * possibleGcd;
        var question = firstNumber + " " + secondNumber;
        var correctAnswer = compute(firstNumber, secondNumber);

        return new QnA(question, correctAnswer);
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
