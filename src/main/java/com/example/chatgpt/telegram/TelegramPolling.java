package com.example.chatgpt.telegram;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import dev.langchain4j.service.Result;

import com.example.chatgpt.ChatService;

@Component
@ConditionalOnProperty(name = "telegram.enabled", havingValue = "true")
public class TelegramPolling {

    private final TelegramService telegramService;
    private final ChatService chatService;

    private Long offset = 0L;

    public TelegramPolling(
            TelegramService telegramService,
            ChatService chatService) {

        this.telegramService = telegramService;
        this.chatService = chatService;
    }

    @Scheduled(fixedDelay = 1000)
    public void processMessages() {

        var updates = telegramService.getUpdates(offset);

        for (TelegramUpdate update : updates) {

            offset = update.update_id() + 1;

            if (update.message() == null) {
                continue;
            }

            if (update.message().text() == null) {
                continue;
            }

            Long chatId = update.message().chat().id();

            String userMessage = update.message().text();

            System.out.println("Mensagem recebida: " + userMessage);

            Result<String> result = chatService.handleRequest(userMessage);

            telegramService.sendMessage(
                    chatId,
                    result.content());
        }
    }
}