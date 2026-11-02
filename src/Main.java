import exception.InvalidGuessException;
import model.GameState;
import repository.WordRepository;
import service.HangmanGame;
import ui.ConsoleInputReader;
import ui.ConsoleView;

public class Main {
    public static void main(String[] args) {
        WordRepository repository = new WordRepository();
        HangmanGame game = new HangmanGame(repository, 6);
        ConsoleView view = new ConsoleView();
        ConsoleInputReader reader = new ConsoleInputReader();

        while (!game.gameIsOver()) {
            view.printState(game);
            char letter;
            while (true) {
                try {
                    letter = reader.readLetter();
                    break;
                } catch (InvalidGuessException e) {
                    System.out.println(e.getMessage());
                }

            }
            game.guess(letter);
        }

        if (game.getGameState() == GameState.WON) {
            view.printWin(game.getSecretWord());
        } else {
            view.printLose(game.getSecretWord());
        }
    }
}