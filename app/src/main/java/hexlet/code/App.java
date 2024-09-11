package hexlet.code;

import hexlet.code.games.Even;

public class App {
    private static final String[] GAME_ID_TO_DESCRIPTION = {
        "Exit",
        "Greet",
        "Even"
    };

    public static void main(String[] args) {
        var gameNumber = Cli.selectGame(GAME_ID_TO_DESCRIPTION);

        var name = gameNumber > 0 ? Cli.getUserName() : null;

        switch (gameNumber) {
            case 2 -> Even.play(name);
            default -> System.out.println("Bye bye");
        }
    }
}
