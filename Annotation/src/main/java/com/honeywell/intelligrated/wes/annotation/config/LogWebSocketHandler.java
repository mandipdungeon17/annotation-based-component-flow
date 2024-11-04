package com.honeywell.intelligrated.wes.annotation.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class LogWebSocketHandler extends TextWebSocketHandler {

    private static final List<WebSocketSession> sessions = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        System.out.println("Connection established with session: " + session.getId() + " added to sessions list " + sessions);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Received message: " + message.getPayload());
    }

    public void sendLog(String log) {
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(new TextMessage(log));
//                System.out.println("Sent log: " + log + " to session: " + session.getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}