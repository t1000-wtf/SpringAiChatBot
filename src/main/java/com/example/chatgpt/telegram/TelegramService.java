package com.example.chatgpt.telegram;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class TelegramService {

    private final RestClient restClient;

    @Value("${telegram.bot-token}")
    private String botToken;

    public TelegramService() {
        this.restClient = RestClient.builder().build();
    }

    public List<TelegramUpdate> getUpdates(Long offset) {

        String url = "https://api.telegram.org/bot"
                + botToken
                + "/getUpdates"
                + "?offset=" + offset
                + "&timeout=30";

        TelegramResponse response = restClient.get()
                .uri(url)
                .retrieve()
                .body(TelegramResponse.class);

        return response.result();
    }

    public void sendMessage(Long chatId, String message) {

        String url = "https://api.telegram.org/bot"
                + botToken
                + "/sendMessage";

        TelegramMessageRequest request = new TelegramMessageRequest(chatId, message);

        restClient.post()
                .uri(url)
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }

    public record TelegramResponse(
            boolean ok,
            List<TelegramUpdate> result) {
    }
}