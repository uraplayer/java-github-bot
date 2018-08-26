package com.fatboa.messaging;

public class BotMessage {

    private final int id;
    private final String message;
    public BotMessage(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("id: %d, message %s\n", id, message);
    }
}


