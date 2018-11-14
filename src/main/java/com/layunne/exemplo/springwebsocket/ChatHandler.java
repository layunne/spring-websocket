package com.layunne.exemplo.springwebsocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Layunne
 */
public class ChatHandler extends TextWebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(ChatHandler.class);

    private HashMap<WebSocketSession,User> sessionList = new HashMap<>();
    private AtomicLong uids = new AtomicLong(0);

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("disconnected session");
        sessionList.remove(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info(message.getPayload());
        session.sendMessage(message);
//        var json = (new ObjectMapper()).readTree(message.getPayload());
//
//        switch (json.get("type").asText()) {
//            case "join": {
//                var user = new User(uids.getAndIncrement(), json.get("name").asText());
//                sessionList.put(session, user);
//                emit(session, new Message("users", sessionList.values()));
//                broadcastToOthers(session, new Message("join", user));
//            }
//            case "say": {
//                broadcast( new Message("say", json.get("data").asText()));
//            }
//
//        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        TextMessage message = new TextMessage("Conected");
        session.sendMessage(message);
        logger.info("connected session");
    }



    void emit(WebSocketSession session, Message msg){
        try {
            session.sendMessage(new TextMessage((new ObjectMapper()).writeValueAsString(msg)));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    //fun broadcast(msg: Message) = sessionList.forEach { emit(it.key, msg) }
    void broadcast(Message msg){
        for (WebSocketSession session: sessionList.keySet()){
            emit(session,msg);
        }
    }
    //fun broadcastToOthers(me: WebSocketSession, msg: Message) = sessionList.filterNot { it.key == me }.forEach { emit(it.key, msg) }
    void broadcastToOthers(WebSocketSession session, Message msg){
        for (WebSocketSession se: sessionList.keySet()){
            if(!session.equals(se)){
                emit(session,msg);
            }
        }
//        sessionList.
    }
}
