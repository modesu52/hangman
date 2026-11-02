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
        int index = game.getWrongSteps() * (STAGES.length - 1) / game.getMaxSteps();
        System.out.println(STAGES[index]);
        System.out.println("Осталось попыток:" + (game.getMaxSteps() - game.getWrongSteps()));
        System.out.println(game.getRevealedWord());
    }

    public void printWin(String secret) {
        System.out.println("Вы выиграли и отгаданное слово было :" + secret);
    }

    public void printLose(String secret) {
        System.out.println("Вы програли, загаданное слово: " + secret);
    }
}
