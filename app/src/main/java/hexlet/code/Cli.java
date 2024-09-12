package hexlet.code;

import hexlet.code.games.Game;

import java.util.Scanner;

public final class Cli {
    public static String getUserName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        var sc = new Scanner(System.in);
        var name = sc.next();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static int selectGame(Game[] gameIdToGame) {
        var selectGameText = createSelectGameText(gameIdToGame);
        System.out.print(selectGameText);

        var sc = new Scanner(System.in);
        var gameId = sc.hasNextInt() ? sc.nextInt() : 0;

        System.out.println();
        return gameId;
    }

    private static String createSelectGameText(Game[] gameIdToGame) {
        var selectTextBuilder = new StringBuilder("Please enter the game number and press Enter.\n");
        for (int gameId = 1; gameId < gameIdToGame.length; ++gameId) {
            appendGameInfo(selectTextBuilder, gameId, gameIdToGame);
        }
        appendGameInfo(selectTextBuilder, 0, gameIdToGame);
        selectTextBuilder.append("Your choice: ");
        return selectTextBuilder.toString();
    }

    private static void appendGameInfo(StringBuilder selectTextBuilder, int gameId, Game[] gameIdToGame) {
        selectTextBuilder
            .append(gameId)
            .append(" - ")
            .append(gameIdToGame[gameId].getName())
            .append("\n");
    }
}
