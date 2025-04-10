package org.example.websocketapp.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import org.example.websocketapp.model.ActiveUser;
import org.example.websocketapp.model.ChatMessage;
import org.example.websocketapp.model.Storage;

@Controller
public class ChatController {

    @MessageMapping("/chat.logIn")
    @SendTo("/topic/all")
    public ChatMessage logIn(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username",chatMessage.getSender());
        Storage.activeUserList.add(new ActiveUser(chatMessage.getSender(),headerAccessor.getSessionId()));
        return chatMessage;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/all")
    public ChatMessage send(@Payload ChatMessage chatMessage){
        return chatMessage;
    }
}