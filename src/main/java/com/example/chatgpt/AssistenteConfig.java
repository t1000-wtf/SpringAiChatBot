package com.example.chatgpt;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

@Configuration
public class AssistenteConfig {

    @Value("${gemini.api-key}")
    private String geminiApiKey;

    @Value("${gemini.model}")
    private String geminiModel;

    @Bean
    public GoogleAiGeminiChatModel googleAiGeminiChatModel() {
        if (geminiApiKey.isBlank()) {
            throw new IllegalStateException(
                    "Configure GEMINI_API_KEY no arquivo .env ou nas variáveis de ambiente.");
        }

        return GoogleAiGeminiChatModel.builder()
                .apiKey(geminiApiKey)
                .modelName(geminiModel)
                .timeout(Duration.ofSeconds(30))
                .maxRetries(3)
                .returnThinking(false)
                .sendThinking(false)
                .build();
    }
}