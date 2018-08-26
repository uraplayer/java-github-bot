package com.fatboa.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fatboa.telegram.TelegramBot;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.io.IOException;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Controller
public class TelegramBotController {
    private static String name;
    private static TelegramBot bot;

    public static void registerBot(TelegramBot bot){
        TelegramBotController.bot=bot;
    }

    @PostMapping("/githubbot")
    ResponseEntity<String> BotMessage(@RequestBody String postPayLoad) {
        String msg;
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(postPayLoad);
            assertNotNull(jsonNode);
            msg = String.format("[%s] User: %s made push to repo: %s with message: %s\n",
                    jsonNode.get("head_commit").get("timestamp"),
                    jsonNode.get("head_commit").get("committer").get("username"),
                    jsonNode.get("repository").get("url"),
                    jsonNode.get("head_commit").get("message"));
        } catch (JsonParseException e1) {
            System.out.println(Arrays.toString(e1.getStackTrace()));
            msg = "error";
        } catch (IOException e2) {
            msg = "ioerror";
            System.out.println(e2.getMessage());
        }

        bot.sendMessageToAllChats(msg);
        return ResponseEntity.ok("ok");
    }

}
