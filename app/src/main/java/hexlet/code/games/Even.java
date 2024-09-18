package hexlet.code.games;

import hexlet.code.QnA;

import static hexlet.code.App.RANDOM;

public final class Even implements Game {
    private static final int RANDOM_NUMBERS_BOUND = 100;

    @Override
    public String getDescription() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public QnA getQuestionAndAnswer() {
        var randomNumber = RANDOM.nextInt(RANDOM_NUMBERS_BOUND);
        var question = String.valueOf(randomNumber);
        var correctAnswer = compute(randomNumber);

        return new QnA(question, correctAnswer);
    }

    private static String compute(int randomNumber) {
        return randomNumber % 2 == 0 ? "yes" : "no";
    }

    @Override
    public String getName() {
        return "Even";
    }

}
