package hexlet.code;

import java.util.Scanner;

public class Cli {
  public static String getUserName() {
    System.out.print("May I have your name? ");
    var sc = new Scanner(System.in);
    return sc.next();
  }

  public static void printWelcomeMessage() {
    System.out.println("Welcome to the Brain Games!");
  }

  public static void greetUser(String name) {
    System.out.println("Hello, " + name + "!");
  }
}
