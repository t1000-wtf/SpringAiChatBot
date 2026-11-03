package com.example.chatgpt;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import dev.langchain4j.service.Result;

class AssistantControllerTest {

    @Test
    @SuppressWarnings("unchecked")
    void acceptsJsonMessageAndReturnsAssistantResponse() throws Exception {
        ChatService chatService = mock(ChatService.class);
        Result<String> result = mock(Result.class);
        when(result.content()).thenReturn("Olá!");
        when(chatService.handleRequest("Oi")).thenReturn(result);

        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(new AssistantController(chatService))
                .build();

        mockMvc.perform(post("/api/assistant")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"message\":\"Oi\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Olá!"));
    }

    @Test
    void rejectsBlankMessage() throws Exception {
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(new AssistantController(mock(ChatService.class)))
                .build();

        mockMvc.perform(post("/api/assistant")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"message\":\"   \"}"))
                .andExpect(status().isBadRequest());
    }
}
