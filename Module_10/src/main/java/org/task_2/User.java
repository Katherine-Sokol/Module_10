package org.task_2;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class User {

    public static final String PATH = "./src/main/java/org/task_2/file.txt";
    private String name;
    private int age;

    public User (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static List <User> createUsers(){
        List <User> users = new ArrayList<>();
        try (Reader reader = new FileReader(PATH)) {
            List<String> lines = new ArrayList<>();
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            for (int i = 1; i < lines.size(); i++) {
                String[] words = lines.get(i).split(" ");
                users.add(new User(words[0], Integer.parseInt(words[1])));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return users;
    }
}
