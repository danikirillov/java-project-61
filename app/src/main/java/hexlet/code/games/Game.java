package hexlet.code.games;

import hexlet.code.QnA;

import static hexlet.code.App.DEFAULT_MAX_ROUNDS_AMOUNT;

public interface Game {
    default String getDescription() {
        return "DESCRIPTION IS NOT DEFINED";
    }

    default QnA getQuestionAndAnswer() {
        return null;
    }

    default int getMaxAttempts() {
        return DEFAULT_MAX_ROUNDS_AMOUNT;
    }

    String getName();
}
