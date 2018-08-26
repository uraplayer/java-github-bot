package com.fatboa.messaging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Logger {
    //                               botName         Date   message
    private static ConcurrentHashMap<String, List<Log>> logs= new ConcurrentHashMap<>();

    public static void putLog(String botName, String logMessage){
        logs.putIfAbsent(botName, new ArrayList<>());
        logs.get(botName).add(new Log(logMessage));
    }


    public static void putLog(String botName, Log log) {
        logs.putIfAbsent(botName, new ArrayList<>());
        logs.get(botName).add(log);
    }

    public static List<Log> getLog(String botName) {
        if (botName==null || botName.equals("")){
            return null;
        }
        return Collections.unmodifiableList(logs.get(botName));
    }
}

