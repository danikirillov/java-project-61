package hexlet.code.games;

import hexlet.code.QnA;

import static hexlet.code.App.RANDOM;

public final class Calc implements Game {

    private static final String[] SIGNS = {"+", "-", "*"};
    private static final int RANDOM_NUMBERS_BOUND = 100;

    @Override
    public String getDescription() {
        return "What is the result of the expression?";
    }

    @Override
    public QnA getQuestionAndAnswer() {
        var firstNumber = RANDOM.nextInt(RANDOM_NUMBERS_BOUND);
        var secondNumber = RANDOM.nextInt(RANDOM_NUMBERS_BOUND);
        var sign = SIGNS[RANDOM.nextInt(SIGNS.length)];
        var question = firstNumber + " " + sign + " " + secondNumber;
        var correctAnswer = compute(firstNumber, sign, secondNumber);

        return new QnA(question, correctAnswer);
    }

    private String compute(int firstNumber, String sign, int secondNumber) {
        return String.valueOf(
            switch (sign) {
                case "+" -> firstNumber + secondNumber;
                case "-" -> firstNumber - secondNumber;
                case "*" -> firstNumber * secondNumber;
                default -> throw new IllegalArgumentException("Not registered sign: ".concat(sign));
            }
        );
    }

    @Override
    public String getName() {
        return "Calc";
    }
}
