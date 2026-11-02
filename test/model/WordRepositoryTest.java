package model;

import org.junit.jupiter.api.Test;
import repository.WordRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordRepositoryTest {
    @Test
    void getRandomWord_SingleWordList_ReturnThisWord() {
        WordRepository wordRepository = new WordRepository(List.of("кот"));
        assertEquals("кот", wordRepository.getRandomWord());
    }

    @Test
    void getRandomWord_defaultList_ReturnWordFromList() {
        WordRepository wordRepository = new WordRepository();
        List<String> testWords = List.of("программа", "компьютер", "клавиатура", "монитор", "алгоритм",
                "переменная", "массив", "метод", "объект", "класс",
                "интерфейс", "наследование", "коллекция", "исключение", "компиляция");

        assertTrue(testWords.contains(wordRepository.getRandomWord()));
    }
}
