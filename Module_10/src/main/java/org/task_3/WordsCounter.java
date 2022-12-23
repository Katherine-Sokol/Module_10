package org.task_3;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

public class WordsCounter {
    public static final String PATH = "./src/main/java/org/task_3/words.txt";

    public String[] splitTextIntoWords() {
        String[] words = new String[0];
        try (Reader reader = new FileReader(PATH)) {
            List<String> lines = new ArrayList<>();
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            StringBuilder text = new StringBuilder();
            for (String line : lines) {
                text.append(line).append(" ");
            }
            words = text.toString().replaceAll("\\W+", " ").split(" ");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return words;
    }

    public void countWords(String[] words) {
        String map = Arrays.stream(words)
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .collect(Collectors.groupingBy(
                        word -> word,
                        TreeMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(e -> e.getKey() + " " + e.getValue())
                .collect(Collectors.joining("\n"));
        System.out.println(map);
    }
}
