package com.example.chatgpt.telegram;

public record TelegramMessageRequest(
        Long chat_id,
        String text) {
}