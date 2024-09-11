package hexlet.code;

public class App {
  public static void main(String[] args) {
    Cli.printWelcomeMessage();
    var name = Cli.getUserName();
    Cli.greetUser(name);
  }
}
