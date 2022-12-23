package org.task_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class UserGSON {
    List<User> users;

    public void createGSONWithUsers() {
        users = User.createUsers();
        String json = null;
        try (Writer writer = new FileWriter("./src/main/java/org/task_2/user.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            json = gson.toJson(users);
            writer.append(json);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(json);
    }

}
