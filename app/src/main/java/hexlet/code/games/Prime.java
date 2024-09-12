package hexlet.code.games;

import java.math.BigInteger;

import static hexlet.code.App.MAX_ROUNDS_AMOUNT;
import static hexlet.code.App.RANDOM;
import static hexlet.code.utils.TextUserInterfaceUtil.congratulateUser;
import static hexlet.code.utils.TextUserInterfaceUtil.getUserAnswer;
import static hexlet.code.utils.TextUserInterfaceUtil.printCorrectAnswerMessage;
import static hexlet.code.utils.TextUserInterfaceUtil.printWrongAnswerMessage;

public final class Prime implements Game {
    private static final int PRIME_CERTAINTY = 10;
    private static final int RANDOM_NUMBERS_BOUND = 340;

    @Override
    public void play(String username) {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        var attempt = 0;
        while (attempt < MAX_ROUNDS_AMOUNT) {
            var probablyPrime = RANDOM.nextInt(RANDOM_NUMBERS_BOUND);
            var question = String.valueOf(probablyPrime);
            var correctAnswer = compute(probablyPrime);

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

    private static String compute(int probablyPrime) {
        return isProbablePrime(probablyPrime) ? "yes" : "no";
    }

    private static boolean isProbablePrime(int probablyPrime) {
        return BigInteger.valueOf(probablyPrime).isProbablePrime(PRIME_CERTAINTY);
    }

    @Override
    public String getName() {
        return "Prime";
    }
}
