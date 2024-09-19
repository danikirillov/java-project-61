package hexlet.code;

import hexlet.code.games.Game;

import java.util.Scanner;

public final class Engine {

    public static void play(Game game) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        var sc = new Scanner(System.in);
        var username = sc.next();
        System.out.println("Hello, " + username + "!");

        if ("Greet".equals(game.getName())) {
            return;
        }

        System.out.println(game.getDescription());

        var attempt = 0;
        while (attempt < game.getMaxAttempts()) {
            var qna = game.getQuestionAndAnswer();

            System.out.printf("Question: %s%nYour answer: ", qna.question());
            var answer = sc.next();

            if (qna.correctAnswer().equals(answer)) {
                System.out.println("Correct!");
                ++attempt;
            } else {
                System.out.printf(
                    "'%s' is wrong answer ;(. Correct answer was '%s'.%nLet's try again, %s!%n",
                    answer,
                    qna.correctAnswer(),
                    username
                );
                return;
            }
        }

        System.out.printf("Congratulations, %s!%n", username);
    }

}
