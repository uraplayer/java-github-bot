package com.fatboa.facebook;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiParser {
    private ObjectMapper mapper;
    private JsonNode jsonNode;
    private Map<String, JsonNode> cacheNodes = new HashMap<>();
    private final String MESSAGINGOBJECT = "messaging";

    public static class Builder {
        public static ApiParser build(String jsonString) throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(jsonString);
            return new ApiParser(mapper, jsonNode);
        }
    }

    private ApiParser(ObjectMapper mapper, JsonNode jsonNode) {
        this.mapper = mapper;
        this.jsonNode = jsonNode;
    }

    public String getSenderId() {
        String result = null;
        JsonNode messaging = getMessagingObjects();
        if (messaging == null) {
            return null;
        }
        if (messaging.isArray()) {
            for (JsonNode message : messaging) {
                result = message.get("sender").get("id").asText();
            }
        }
        return result;
    }

    public String getMessage() {
        String result = null;
        JsonNode messaging = getMessagingObjects();
        if (messaging == null) {
            return null;
        }
        if (messaging.isArray()) {
            for (JsonNode message : messaging) {
                try {
                    result = message.get("message").get("text").asText();
                } catch (NullPointerException ex){
                    ex.printStackTrace();
                    return result;
                }
            }
        }
        return result;
    }

    private JsonNode getMessagingObjects() {
        JsonNode result = cacheNodes.get(MESSAGINGOBJECT);
        if (result != null) {
            return result;
        }
        JsonNode node = jsonNode.get("entry");
        if (node.isArray()) {
            for (JsonNode entry : node) {
                result = entry.get(MESSAGINGOBJECT);
            }
        }
        if (result != null) {
            cacheNodes.put(MESSAGINGOBJECT, result);
        }
        return result;
    }
}

