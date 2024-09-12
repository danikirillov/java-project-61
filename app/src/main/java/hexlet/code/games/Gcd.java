package hexlet.code.games;

import java.math.BigInteger;
import java.util.Scanner;

import static hexlet.code.App.MAX_ROUNDS_AMOUNT;
import static hexlet.code.App.RANDOM;
import static hexlet.code.utils.TextUserInterfaceUtil.congratulateUser;
import static hexlet.code.utils.TextUserInterfaceUtil.printCorrectAnswerMessage;
import static hexlet.code.utils.TextUserInterfaceUtil.printWrongAnswerMessage;

public class Gcd implements Game {

    @Override
    public void play(String username) {
        System.out.println("Find the greatest common divisor of given numbers.");

        var attempt = 0;
        var sc = new Scanner(System.in);

        while (attempt < MAX_ROUNDS_AMOUNT) {
            var possibleGcd = RANDOM.nextInt(8) + 1;
            var firstNumber = RANDOM.nextInt(13) * possibleGcd;
            var secondNumber = RANDOM.nextInt(13) * possibleGcd;

            System.out.printf(
                "Question: %d %d%nYour answer: ",
                firstNumber,
                secondNumber
            );

            var answer = sc.next();

            var correctAnswer = compute(firstNumber, secondNumber);
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
