package model;

import java.util.HashSet;
import java.util.Set;

public class Word {
    final private String secret;
    final private Set<Character> usedLetters = new HashSet<>();

    public Word(String secret) {
        this.secret = secret.toLowerCase();
    }

    public boolean letterInTheWord(char letter) {
        return secret.indexOf(Character.toLowerCase(letter)) != -1;
    }

    public void guess(char letter) {
        usedLetters.add(Character.toLowerCase(letter));
    }

    public boolean isGuessedFully() {
        return (!reveal().contains("_"));
    }

    public Set<Character> getUsedLetters() {
        return Set.copyOf(usedLetters);
    }

    public String reveal() {
        StringBuilder returnedWord = new StringBuilder();
        for (int i = 0; i < secret.length(); i++) {
            if (usedLetters.contains(secret.charAt(i))) {
                returnedWord.append(secret.charAt(i));
            } else {
                returnedWord.append("_");
            }
        }
        return returnedWord.toString();
    }
}
