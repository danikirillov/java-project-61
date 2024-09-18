package hexlet.code;

import hexlet.code.games.Game;

import static hexlet.code.utils.TextUserInterfaceUtil.congratulateUser;
import static hexlet.code.utils.TextUserInterfaceUtil.getUserAnswer;
import static hexlet.code.utils.TextUserInterfaceUtil.printCorrectAnswerMessage;
import static hexlet.code.utils.TextUserInterfaceUtil.printWrongAnswerMessage;

public final class Engine {

    public static void play(Game game, String username) {
        System.out.println(game.getDescription());

        var attempt = 0;
        while (attempt < game.getMaxAttempts()) {
            var qna = game.getQuestionAndAnswer();

            var answer = getUserAnswer(qna.question());
            if (qna.correctAnswer().equals(answer)) {
                printCorrectAnswerMessage();
                ++attempt;
            } else {
                printWrongAnswerMessage(answer, qna.correctAnswer(), username);
                return;
            }
        }

        congratulateUser(username);
    }

}
