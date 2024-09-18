package hexlet.code.utils;

import hexlet.code.games.Game;

import java.util.Scanner;

import static hexlet.code.App.SHIFT_FOR_EXIT_AND_GREET;

public final class TextUserInterfaceUtil {
    public static void congratulateUser(String name) {
        System.out.printf("Congratulations, %s!%n", name);
    }

    public static void printCorrectAnswerMessage() {
        System.out.println("Correct!");
    }

    public static void printWrongAnswerMessage(String answer, String correctAnswer, String name) {
        System.out.printf(
            "'%s' is wrong answer ;(. Correct answer was '%s'.%nLet's try again, %s!%n",
            answer,
            correctAnswer,
            name
        );
    }

    public static String getUserAnswer(String question) {
        var sc = new Scanner(System.in);
        System.out.printf("Question: %s%nYour answer: ", question);
        return sc.next();
    }

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
        appendGameInfo(selectTextBuilder, 1, "Greet");
        for (int gameId = 0; gameId < gameIdToGame.length; ++gameId) {
            appendGameInfo(selectTextBuilder, gameId, gameIdToGame[gameId].getName());
        }
        appendGameInfo(selectTextBuilder, 0, "Exit");
        selectTextBuilder.append("Your choice: ");
        return selectTextBuilder.toString();
    }

    private static void appendGameInfo(StringBuilder selectTextBuilder, int gameId, String gameName) {
        selectTextBuilder
            .append(gameId + SHIFT_FOR_EXIT_AND_GREET)
            .append(" - ")
            .append(gameName)
            .append("\n");
    }
}
