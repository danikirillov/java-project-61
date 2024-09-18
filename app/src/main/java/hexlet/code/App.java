package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Game;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Random;

import static hexlet.code.utils.TextUserInterfaceUtil.getUserName;
import static hexlet.code.utils.TextUserInterfaceUtil.selectGame;

public class App {
    public static final int DEFAULT_MAX_ROUNDS_AMOUNT = 3;
    public static final int EXIT_ID = 0;
    public static final int GREET_ID = 1;
    public static final int SHIFT_FOR_EXIT_AND_GREET = 2;
    public static final Random RANDOM = new Random();
    private static final Game[] GAME_ID_TO_GAME = {
        new Even(),
        new Calc(),
        new Gcd(),
        new Progression(),
        new Prime()
    };

    public static void main(String[] args) {
        var gameId = selectGame(GAME_ID_TO_GAME);
        if (gameId >= GAME_ID_TO_GAME.length + SHIFT_FOR_EXIT_AND_GREET || gameId < 0) {
            return;
        }

        if (gameId == EXIT_ID) {
            return;
        }

        var username = getUserName();

        if (gameId == GREET_ID) {
            return;
        }

        Engine.play(GAME_ID_TO_GAME[gameId - SHIFT_FOR_EXIT_AND_GREET], username);
    }
}
