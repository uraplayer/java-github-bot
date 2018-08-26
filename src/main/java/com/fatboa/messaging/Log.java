package com.fatboa.messaging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log{
    private final String date;
    private final String value;
    private static DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Log(String value) {
        this.date =dateFormat.format(new Date());
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public String getValue() {
        return value;
    }
}
