package hexlet.code.games;

import java.math.BigInteger;
import java.util.Scanner;

import static hexlet.code.App.MAX_ROUNDS_AMOUNT;
import static hexlet.code.App.RANDOM;
import static hexlet.code.utils.TextUserInterfaceUtil.congratulateUser;
import static hexlet.code.utils.TextUserInterfaceUtil.printCorrectAnswerMessage;
import static hexlet.code.utils.TextUserInterfaceUtil.printWrongAnswerMessage;

public class Prime implements Game {
    private static final int PRIME_CERTAINTY = 10;

    @Override
    public void play(String username) {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        var attempt = 0;
        var sc = new Scanner(System.in);

        while (attempt < MAX_ROUNDS_AMOUNT) {
            var probablyPrime = RANDOM.nextInt(340);
            System.out.printf("Question: %d%nYour answer: ", probablyPrime);

            var answer = sc.next();

            var correctAnswer = isProbablePrime(probablyPrime) ? "yes" : "no";
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

    private static boolean isProbablePrime(int probablyPrime) {
        return BigInteger.valueOf(probablyPrime).isProbablePrime(PRIME_CERTAINTY);
    }

    @Override
    public String getName() {
        return "Prime";
    }
}
