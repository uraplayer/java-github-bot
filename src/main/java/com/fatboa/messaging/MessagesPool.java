package com.fatboa.messaging;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessagesPool {
   private ConcurrentHashMap<Integer, BotMessage> faceBookMessages = new ConcurrentHashMap<>();
    private int messageCounter=0;

    public MessagesPool() {}

    public String addMessage(String message){
        addMessageCounter();
        BotMessage botMessage=new BotMessage(messageCounter, message);
        faceBookMessages.put(messageCounter, botMessage);
        return botMessage.toString();
    }

    private synchronized void addMessageCounter() {
        messageCounter++;
    }

    public String getMessageValue(int messageNumber){
        return faceBookMessages.get(messageNumber).getMessage();
    }

    public Map<Integer, BotMessage> getFaceBookMessages() {
        return Collections.unmodifiableMap(faceBookMessages);
    }

    @Override
    public String toString() {
       StringBuilder result= new StringBuilder();
        for (Map.Entry<Integer,BotMessage> pair : faceBookMessages.entrySet()) {
            result.append(String.format("id: %d, message: %s\n", pair.getKey(), pair.getValue().getMessage()));
        }
       return result.toString();
    }
}
