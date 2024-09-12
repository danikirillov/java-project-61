package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.App.MAX_ROUNDS_AMOUNT;
import static hexlet.code.App.RANDOM;
import static hexlet.code.utils.TextUserInterfaceUtil.congratulateUser;
import static hexlet.code.utils.TextUserInterfaceUtil.printCorrectAnswerMessage;
import static hexlet.code.utils.TextUserInterfaceUtil.printWrongAnswerMessage;

public class Calc implements Game {

    private static final String[] SIGNS = {"+", "-", "*"};

    @Override
    public void play(String username) {
        System.out.println("What is the result of the expression?");

        var attempt = 0;
        var sc = new Scanner(System.in);

        while (attempt < MAX_ROUNDS_AMOUNT) {
            var firstNumber = RANDOM.nextInt(100);
            var secondNumber = RANDOM.nextInt(100);
            var sign = SIGNS[RANDOM.nextInt(SIGNS.length)];

            System.out.printf(
                "Question: %d %s %d%nYour answer: ",
                firstNumber,
                sign,
                secondNumber
            );

            var answer = sc.next();

            var correctAnswer = compute(firstNumber, sign, secondNumber);
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
