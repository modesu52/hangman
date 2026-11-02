package ui;

import service.HangmanGame;

public class ConsoleView {
    private static final String[] STAGES = {
            "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="
    };

    public void printState(HangmanGame game) {

    }

    public void printWin(String secret) {
        System.out.println("Вы выиграли и отгаданное слово было :" + secret);
    }

    public void printLose(String secret) {
        System.out.println("Вы програли, загаданное слово: " + secret);
    }
}
