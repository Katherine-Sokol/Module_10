package org.task_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneNumberReader {

    public static final String PATH = "./src/main/java/org/task_1/file.txt";

    public void printPhoneNumbers() {
        findPhoneNumbers(readLinesFromFile());
    }

    public List<String> readLinesFromFile() {
        List<String> lines = new ArrayList<>();
        try (Reader reader = new FileReader(PATH)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        if (lines.isEmpty()) {
            System.out.println("File is empty");
        }
        return lines;
    }

    public void findPhoneNumbers(List<String> lines) {
        for (String line : lines) {
            if (line.matches("\\(\\d{3}\\)\\s\\d{3}-\\d{4}")
                    || line.matches("\\d{3}-\\d{3}-\\d{4}")) {
                System.out.println(line);
            }
        }
    }
}
