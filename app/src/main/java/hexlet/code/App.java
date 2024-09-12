package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Exit;
import hexlet.code.games.Game;
import hexlet.code.games.Gcd;
import hexlet.code.games.Greet;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Random;

public class App {
    public static final int MAX_ROUNDS_AMOUNT = 3;
    public static final Random RANDOM = new Random();
    private static final Game[] GAME_ID_TO_GAME = {
        new Exit(),
        new Greet(),
        new Even(),
        new Calc(),
        new Gcd(),
        new Progression(),
        new Prime()
    };

    public static void main(String[] args) {
        var gameId = Cli.selectGame(GAME_ID_TO_GAME);
        if (gameId >= GAME_ID_TO_GAME.length || gameId <= 0) {
            GAME_ID_TO_GAME[0].play("");
            return;
        }

        var name = Cli.getUserName();
        GAME_ID_TO_GAME[gameId].play(name);
    }
}
