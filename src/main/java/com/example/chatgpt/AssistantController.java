package com.example.chatgpt;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.langchain4j.service.Result;

@RestController
@RequestMapping("/api/assistant")
public class AssistantController {

    private final ChatService chatService;

    public AssistantController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public String askAssistant(@RequestBody AssistantRequest request) {
        if (request == null || request.message() == null || request.message().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A mensagem não pode estar vazia.");
        }

        Result<String> result = chatService.handleRequest(request.message());

        return result.content();
    }

    public record AssistantRequest(String message) {
    }
}
