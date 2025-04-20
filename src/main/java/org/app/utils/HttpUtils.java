package org.app.utils;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;


public class HttpUtils {

    public void getUserEvents(String userName) {
        try {
            URL url = new URL("https://api.github.com/users/" + userName + "/events");

            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setRequestProperty("Accept", "application/vnd.github.v3+json");
            int responseCode = httpsURLConnection.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {

                File file = new File("events.json");
                BufferedReader in = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                in.close();
                httpsURLConnection.disconnect();

                try (FileWriter fileWriter = new FileWriter(file)) {
                    fileWriter.write(content.toString());
                }
                System.out.println("Connection Successful\n\n");
            }
            else {
                System.out.println("Connection Failed or Current User not founded\n\n");
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
