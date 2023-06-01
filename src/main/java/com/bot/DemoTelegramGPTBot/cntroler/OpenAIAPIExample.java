package com.bot.DemoTelegramGPTBot.cntroler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class OpenAIAPIExample {
    public static void main(String[] args) throws IOException {
        // Установите ваш API-ключ OpenAI
        String apiKey = "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";

        // Установите параметры запроса
        String endpoint = "https://api.openai.com/v1/engines/davinci-codex/completions";
        String prompt = "Once upon a time";
        int maxTokens = 100;

        // Создайте URL-адрес запроса
        String requestUrl = endpoint + "?prompt=" + prompt + "&max_tokens=" + maxTokens;

        // Создайте объект URL для отправки запроса
        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Установите заголовок авторизации с помощью API-ключа
        connection.setRequestProperty("Authorization", "Bearer " + apiKey);

        // Установите метод запроса
        connection.setRequestMethod("GET");

        // Прочитайте ответ от API
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder responseBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBuilder.append(line);
        }
        reader.close();

        // Обработайте ответ
        String response = responseBuilder.toString();
        System.out.println("API Response: " + response);

        // Закройте соединение
        connection.disconnect();
    }
}
