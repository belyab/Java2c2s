package ru.stud.kpfu.baigulova.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpService {

    public String get(String city) throws IOException {
        URL weatherUrl = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=15a7261430404fc9ce700900c2e4d9ff");
        HttpURLConnection connection = (HttpURLConnection) weatherUrl.openConnection();
        StringBuilder result = new StringBuilder();

        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            String input;
            while ((input = reader.readLine()) != null) {
                result.append(input);
            }
        } catch (Exception e) {
            return null;
        }

        connection.disconnect();
        return result.toString();
    }
}
