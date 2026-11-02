package ui;

import exception.InvalidGuessException;

import java.util.Scanner;

public class ConsoleInputReader {
    private final Scanner scanner = new Scanner(System.in);

    public char readLetter() {
        String word = scanner.nextLine();
        if (!(word.length() == 1 &&  Character.isLetter(word.charAt(0)))) {
           throw new InvalidGuessException("неправильный ввод буквы");
        }
        return word.charAt(0);
    }
}
