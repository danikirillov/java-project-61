package hexlet.code.games;

import static hexlet.code.App.MAX_ROUNDS_AMOUNT;
import static hexlet.code.App.RANDOM;
import static hexlet.code.utils.TextUserInterfaceUtil.congratulateUser;
import static hexlet.code.utils.TextUserInterfaceUtil.getUserAnswer;
import static hexlet.code.utils.TextUserInterfaceUtil.printCorrectAnswerMessage;
import static hexlet.code.utils.TextUserInterfaceUtil.printWrongAnswerMessage;

public final class Calc implements Game {

    private static final String[] SIGNS = {"+", "-", "*"};
    private static final int RANDOM_NUMBERS_BOUND = 100;

    @Override
    public void play(String username) {
        System.out.println("What is the result of the expression?");

        var attempt = 0;
        while (attempt < MAX_ROUNDS_AMOUNT) {
            var firstNumber = RANDOM.nextInt(RANDOM_NUMBERS_BOUND);
            var secondNumber = RANDOM.nextInt(RANDOM_NUMBERS_BOUND);
            var sign = SIGNS[RANDOM.nextInt(SIGNS.length)];
            var question = firstNumber + " " + sign + " " + secondNumber;
            var correctAnswer = compute(firstNumber, sign, secondNumber);

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

    private String compute(int firstNumber, String sign, int secondNumber) {
        return String.valueOf(
            switch (sign) {
                case "+" -> firstNumber + secondNumber;
                case "-" -> firstNumber - secondNumber;
                case "*" -> firstNumber * secondNumber;
                default -> 0;
            }
        );
    }

    @Override
    public String getName() {
        return "Calc";
    }
}
