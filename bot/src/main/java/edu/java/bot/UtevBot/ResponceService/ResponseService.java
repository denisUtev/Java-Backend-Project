package edu.java.bot.UtevBot.ResponceService;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class ResponseService {

    public ResponseService() {

    }

    public SendMessage getAnswer(Update update) {
        System.out.println(update.message().text());
        //var user = userRegistry.getUser(update.message().chat().id());
        return new SendMessage(update.message().chat().id(), update.message().text());
    }
}
