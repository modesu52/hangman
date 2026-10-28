package repository;


import java.util.List;
import java.util.Random;

public class WordRepository {
    private final List<String> words;
    private final Random random = new Random();

    public WordRepository(List<String> words) {
        this.words = words;
    }

    public WordRepository() {
        this(List.of(
                "программа",
                "компьютер",
                "клавиатура",
                "монитор",
                "алгоритм",
                "переменная",
                "массив",
                "метод",
                "объект",
                "класс",
                "интерфейс",
                "наследование",
                "коллекция",
                "исключение",
                "компиляция"
        ));
    }

    public String getRandomWord() {
        int rand = random.nextInt(words.size());
        return words.get(rand);
    }
}

