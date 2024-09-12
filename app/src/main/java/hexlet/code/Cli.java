package hexlet.code;

import hexlet.code.games.Game;

import java.util.Scanner;

public class Cli {
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
        var gameId = sc.nextInt();

        System.out.println();
        return gameId;
    }

    private static String createSelectGameText(Game[] gameIdToGame) {
        var selectTextBuilder = new StringBuilder("Please enter the game number and press Enter.\n");
        for (int gameId = gameIdToGame.length - 1; gameId >= 0; --gameId) {
            selectTextBuilder
                .append(gameId)
                .append(" - ")
                .append(gameIdToGame[gameId].getName())
                .append("\n");
        }
        selectTextBuilder.append("Your choice: ");
        return selectTextBuilder.toString();
    }
}
