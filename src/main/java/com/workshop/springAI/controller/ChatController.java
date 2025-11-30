package com.workshop.springAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/chat")
@Log4j2
public class ChatController {
    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @PostMapping("/chat-static")
    public String chatStatic(@RequestBody String message) {
        log.info("/chat-static is invoked with message: {}", message);
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

    @PostMapping(value = "/chat-stream")
    public Flux<String> chatStream(@RequestBody String message) {
        log.info("/chat-stream is invoked with message: {}", message);
        return chatClient.prompt()
                .user(message)
                .stream()
                .content();
    }

    @PostMapping(value = "/chat-response")
    public ChatResponse chatResponse(@RequestBody String message) {
        log.info("/chat-response is invoked with message: {}", message);
        return chatClient.prompt()
                .user(message)
                .call()
                .chatResponse();
    }

}
