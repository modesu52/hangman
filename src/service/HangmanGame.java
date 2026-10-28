package service;

import model.GameState;
import model.Word;
import repository.WordRepository;

public class HangmanGame {
    private final Word word;
    final private int maxSteps;
    private int wrongSteps;
    private GameState gameState;

    public HangmanGame(Word word, int maxSteps) {
        this.word = word;
        this.maxSteps = maxSteps;
        this.wrongSteps = 0;
        this.gameState = GameState.IN_PROGRESS;
    }

    public HangmanGame(WordRepository wordRepository, int maxSteps) {
        this(new Word(wordRepository.getRandomWord()), maxSteps);
    }

    public void guess(char letter) {
        word.guess(letter);
        if (!word.letterInTheWord(letter)) {
            wrongSteps += 1;
        }

        if (word.isGuessedFully()) {
            gameState = GameState.WON;
        } else if (wrongSteps >= maxSteps) {
            gameState = GameState.LOST;
        }
    }

    public boolean gameIsOver() {
        return gameState != GameState.IN_PROGRESS;
    }

    public String getRevealedWord() {
        return word.reveal();
    }

    public int getMaxSteps() {
        return maxSteps;
    }

    public int getWrongSteps() {
        return wrongSteps;
    }

    public GameState getGameState() {
        return gameState;
    }
}
