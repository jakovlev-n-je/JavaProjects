package com.vgu.cs.course2.group11.trie;

public class Word {

    private final int count;

    private final String word;

    public Word(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return String.format("Слово: %s | Повторений в словаре: %d", word, count);
    }
}
