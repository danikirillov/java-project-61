package hexlet.code.games;

import hexlet.code.QnA;

import java.math.BigInteger;

import static hexlet.code.App.RANDOM;

public final class Prime implements Game {
    private static final int PRIME_CERTAINTY = 10;
    private static final int RANDOM_NUMBERS_BOUND = 340;

    @Override
    public String getDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public QnA getQuestionAndAnswer() {
        var probablyPrime = RANDOM.nextInt(RANDOM_NUMBERS_BOUND);
        var question = String.valueOf(probablyPrime);
        var correctAnswer = compute(probablyPrime);

        return new QnA(question, correctAnswer);
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
