package org.task_3;

public class WordsCounterTest {

    public static void main(String[] args) {
        WordsCounter wordsCounter = new WordsCounter();
        wordsCounter.countWords(wordsCounter.splitTextIntoWords());
    }
}
