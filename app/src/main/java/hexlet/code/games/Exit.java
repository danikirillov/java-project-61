package hexlet.code.games;

public final class Exit implements Game {

    @Override
    public void play(String username) {
        System.out.println("Bye bye");
    }

    @Override
    public String getName() {
        return "Exit";
    }
}
