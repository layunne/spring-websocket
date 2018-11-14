package com.layunne.exemplo.springwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

/**
 * @author Layunne
 */
//@Controller
public class WebSocketController {

//    @Autowired
//    private SimpMessageSendingOperations messagingTemplate;



//    @MessageMapping("greeting")
//    @SendTo("greeting")
//    public String processMessageFromClient(@Payload String message) {
////        String name = new Gson().fromJson(message, Map.class).get("name").toString();
//        System.out.println(message);
//        return message;
//    }
//
//    @MessageExceptionHandler
//    public String handleException(Throwable exception) {
//        messagingTemplate.convertAndSend("/errors", exception.getMessage());
//        return exception.getMessage();
//    }

}
