package com.example.chatgpt;

import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface ChatService {

    @SystemMessage("""
                            Você é um assistente pessoal inteligente, simples e prestativo.

            Ajude o usuário com dúvidas do dia a dia, estudos e projetos de programação.

            Regras:
            - Responda em português brasileiro.
            - Seja claro, objetivo e didático.
            - Explique conceitos de forma simples.
            - Ajude a desenvolver e corrigir códigos.
            - Não invente informações.
            - Se não souber, seja transparente.
            - Evite respostas desnecessariamente longas.
            - Antes de sugerir grandes mudanças, entenda a estrutura do projeto.
                                                                                                """)
    Result<String> handleRequest(@UserMessage String userMessage);
}
