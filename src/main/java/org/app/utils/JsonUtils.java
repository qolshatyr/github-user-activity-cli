package org.app.utils;


import com.google.gson.Gson;
import org.app.model.GitHubEvent;

import java.io.*;
import java.util.List;


public class JsonUtils {

    public static List<GitHubEvent> deSerializeGitHubEvents() throws RuntimeException {
        List<GitHubEvent> events;

        Gson gson = new Gson();
        File file = new File("events.json");
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        events = gson.fromJson(content.toString(), new com.google.gson.reflect.TypeToken<List<GitHubEvent>>() {
        }.getType());

        return events;
    }
}


