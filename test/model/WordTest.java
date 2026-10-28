package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordTest {
    @Test
    void letterInTheWord_Present_True() {
        Word word = new Word("кот");
        assertTrue(word.letterInTheWord('к'));
    }

    @Test
    void letterInTheWord_Absent_False() {
        Word word = new Word("кот");
        assertFalse(word.letterInTheWord('а'));
    }

    @Test
    void capitalLetterInTheWord_Present_True() {
        Word word = new Word("кот");
        assertTrue(word.letterInTheWord('К'));
    }

    @Test
    void capitalLetterInTheWord_Absent_False() {
        Word word = new Word("кот");
        assertFalse(word.letterInTheWord('А'));
    }

    @Test
    void reveal_noGuesses_returnsAllUnderscores() {
        Word word = new Word("кот");
        assertEquals("___", word.reveal());
    }

    @Test
    void revealSomeLettersCorrectly() {
        Word word = new Word("кот");
        word.guess('к');
        word.guess('т');
        assertEquals("к_т", word.reveal());
    }

    @Test
    void revealWrongLetter_returnAllUnderscores() {
        Word word = new Word("кот");
        word.guess('а');
        assertEquals("___", word.reveal());
    }

    @Test
    void getUsedLetters_fourDistinctGuesses_returnsSizeFour() {
        Word word = new Word("кот");
        word.guess('о');
        word.guess('п');
        word.guess('м');
        word.guess('к');
        assertEquals(4, word.getUsedLetters().size());
    }

    @Test
    void isGuessedFully_notAllWord() {
        Word word = new Word("кот");
        word.guess('о');
        word.guess('п');
        word.guess('т');
        word.guess('и');
        assertFalse(word.isGuessedFully());
    }

    @Test
    void isGuessedFully_allWordIsOpen() {
        Word word = new Word("кот");
        word.guess('о');
        word.guess('п');
        word.guess('к');
        word.guess('т');
        assertTrue(word.isGuessedFully());
    }

    @Test
    void guessSomeLettersDifferentCaseDoesNotBrakeState() {
        Word word = new Word("кот");
        word.guess('К');
        word.guess('к');
        assertEquals(1, word.getUsedLetters().size());
    }
}
