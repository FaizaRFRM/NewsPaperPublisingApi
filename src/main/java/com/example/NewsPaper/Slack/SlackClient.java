package com.example.NewsPaper.Slack;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class SlackClient {
    public String sendMessage(String text){
        return WebClient.create().post()
                .uri("")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new SlackLoad(text))
                .retrieve().bodyToMono(String.class)
                .block();
    }
}

