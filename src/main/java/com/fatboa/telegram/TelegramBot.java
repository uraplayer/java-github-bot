package com.fatboa.telegram;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TelegramBot extends TelegramLongPollingBot{

    private final String ECHO_BOT_COMMAND="/echo ";
    private final String START_BOT_COMMAND = "/start";
    private final String name;

    private final Map<Long, Chat> chats=new HashMap<>();



    public TelegramBot(String name) {
        this.name=name;
    }

    public static TelegramBot init(String name){
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        TelegramBot bot=new TelegramBot(name);
        try {
            botsApi.registerBot(bot);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
        return bot;
    }


    public void sendMessageToAllChats(String msg){
        for (Map.Entry<Long, Chat> chatEntry: chats.entrySet()){
            SendMessage message = new SendMessage()
                    .setChatId(chatEntry.getKey())
                    .setText(msg);
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private void addNewChatIfnotExist(Update update){
        synchronized (chats){
        if (chats.get(update.getMessage().getChatId())==null) {
                chats.put(update.getMessage().getChatId(), update.getMessage().getChat());
            }
        }
    }


    @Override
    public void onUpdateReceived(Update update) {
        String msg=update.getMessage().getText();
        if (!update.hasMessage() || msg==null || msg.equals("")){
            return;
        }

        String returnMessage;
        addNewChatIfnotExist(update);
        if (msg.equals(START_BOT_COMMAND)){
            returnMessage= "Hello! A am Tel-Ran Github CVBank repo bot (https://github.com/TRCVBANK/BACK)! Type /echo {string} to get bot echo";
        }
        else if (msg.startsWith(ECHO_BOT_COMMAND)){
            returnMessage= msg.replaceFirst(ECHO_BOT_COMMAND, "");
        }
        else if (msg.equals("/shutdown")){
            returnMessage="Сам пойди и выключись об стену, а мне работать надо!";
        }
        else {
            return;
        }

       SendMessage message = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(returnMessage);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "githubCommitsNotifybot";
    }
//657815538:AAGzXI9keb8SffIcfAAgfZRkjuQDG1HBj7c
    @Override
    public String getBotToken() {
        return "657815538:AAGzXI9keb8SffIcfAAgfZRkjuQDG1HBj7c";
    }

    public String getName() {
        return name;
    }
}
