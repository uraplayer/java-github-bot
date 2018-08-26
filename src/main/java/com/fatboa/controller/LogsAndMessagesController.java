package com.fatboa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fatboa.messaging.*;

import java.util.List;

@Controller
public class LogsAndMessagesController {
    @RequestMapping("/logs/{botName}")
    public String logsHandler
            (@PathVariable String botName, Model model) {

        if (botName.equals("")) {
            return "error";
        }

        List<Log> botLogs = Logger.getLog(botName);
        if (botLogs == null) {
            return "error";
        }

        model.addAttribute("botName", botName);
        model.addAttribute("botLogs", botLogs);
        return "logs";
    }

    @RequestMapping("/test")
    public String testHandler(Model model) {
        String botName = "BotOfTheYear";
        Logger.putLog(botName, "Log  Message 1 from "+botName);
        Logger.putLog(botName, "Log Message 2 from "+botName);
        Logger.putLog(botName, "Log Message 3 from test bot "+botName);
        model.addAttribute("messages", Logger.getLog(botName));
        return "test";
    }


    @RequestMapping("/getlogsjson/{botName}")
    public ResponseEntity<Object> getLogsJsonHandler
            (@PathVariable String botName) {
        if (botName.equals("")) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        List<Log> logs = Logger.getLog(botName);

        return logs == null ?
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(logs, HttpStatus.OK);
    }
}
//

