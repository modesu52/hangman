# Hangman

Консольная игра "Виселица" на чистой Java (без Maven/Gradle) — учебный проект для отработки основ языка: ООП, коллекции, исключения, enum, конструкторы, юнит-тестирование.

## Архитектура

```
src/
├── Main.java              — точка входа
├── model/
│   ├── Word.java           — состояние загаданного слова, угаданные буквы
│   ├── GameState.java      — enum: IN_PROGRESS / WON / LOST
│   └── Difficulty.java     — пока не используется (зарезервировано на будущее)
├── repository/
│   └── WordRepository.java — источник слов, выбор случайного слова
├── service/
│   └── HangmanGame.java    — игровой цикл и правила (попытки, победа/поражение)
├── ui/
│   ├── ConsoleView.java         — вывод состояния игры и рисунка виселицы
│   └── ConsoleInputReader.java  — чтение и валидация ввода игрока
└── exception/
    └── InvalidGuessException.java — исключение для невалидного ввода

test/
└── model/  — юнит-тесты (JUnit 5) для Word, WordRepository, HangmanGame
```

Зависимости внутри слоёв идут в одну сторону: `ui → service → model`, `repository` используется только `service`.

## Статус

Проект в процессе разработки:
- [x] `model`, `repository`, `service` — реализованы и покрыты тестами
- [x] `exception` — реализован
- [ ] `ui.ConsoleView.printState()` — ещё не реализован (заглушка)
- [ ] `Main` — игровой цикл ещё не собран, пока просто `Hello world!`
- [ ] Часть тестов `HangmanGameTest` ещё не дописана

## Сборка и запуск

Maven/Gradle не используются. Зависимости (JUnit 5) лежат локально в `lib/`.

```bash
javac -cp "lib/*" -d out $(find src test -name "*.java")
java -cp out Main
```

## Тесты

Тесты в `test/` — JUnit 5. Запускаются из IntelliJ IDEA (модуль настроен с `test` как Test Sources Root и библиотекой JUnit из `lib/`), либо через `javac`/`java` с JUnit Console Launcher.
