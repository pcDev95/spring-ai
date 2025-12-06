package com.workshop.springAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {
    private final ChatClient chatClient;

    @Value("classpath:/images/test_image.jpeg")
    private Resource image;

    @GetMapping("/describe")
    public String describeImage() {
        return chatClient.prompt().user(i -> {
            i.text("Can you explain what you see in the image");
            i.media(MimeTypeUtils.IMAGE_JPEG, image);
        })
                .call()
                .content();

    }

}
