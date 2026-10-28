package model;

import org.junit.jupiter.api.Test;
import service.HangmanGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HangmanGameTest {
    @Test
    void guessCorrectLetter_IsNotWrongSteps() {
        Word word = new Word("кот");
        HangmanGame game = new HangmanGame(word, 5);
        game.guess('к');

        assertEquals(0, game.getWrongSteps());
    }


}
