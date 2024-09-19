package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Game;
import hexlet.code.games.Gcd;
import hexlet.code.games.Greet;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static final int DEFAULT_MAX_ROUNDS_AMOUNT = 3;
    public static final int SHIFT_FOR_EXIT = 1;
    public static final Random RANDOM = new Random();
    private static final Game[] GAME_ID_TO_GAME = {
        new Greet(),
        new Even(),
        new Calc(),
        new Gcd(),
        new Progression(),
        new Prime()
    };

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        var selectGameText = createSelectGameText();
        System.out.print(selectGameText);
        System.out.print("Your choice: ");

        var sc = new Scanner(System.in);
        var gameId = sc.hasNextInt() ? sc.nextInt() : 0;

        System.out.println();
        if (gameId >= GAME_ID_TO_GAME.length + SHIFT_FOR_EXIT || gameId <= 0) {
            return;
        }

        Engine.play(GAME_ID_TO_GAME[gameId - SHIFT_FOR_EXIT]);
    }

    private static String createSelectGameText() {
        var selectTextBuilder = new StringBuilder();
        for (int gameId = 0; gameId < GAME_ID_TO_GAME.length; ++gameId) {
            appendGameInfo(selectTextBuilder, gameId + SHIFT_FOR_EXIT, GAME_ID_TO_GAME[gameId].getName());
        }
        appendGameInfo(selectTextBuilder, 0, "Exit");
        return selectTextBuilder.toString();
    }

    private static void appendGameInfo(StringBuilder selectTextBuilder, int gameId, String gameName) {
        selectTextBuilder
            .append(gameId)
            .append(" - ")
            .append(gameName)
            .append("\n");
    }
}
