package com.example.chatgpt.telegram;

public record TelegramUpdate(
        Long update_id,
        Message message) {

    public record Message(
            Long message_id,
            Chat chat,
            String text) {
    }

    public record Chat(
            Long id) {
    }
}