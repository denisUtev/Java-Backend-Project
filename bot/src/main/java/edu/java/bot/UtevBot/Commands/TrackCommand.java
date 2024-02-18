package edu.java.bot.UtevBot.Commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class TrackCommand implements Command {

    @Override
    public String command() {
        return "/track";
    }

    @Override
    public String description() {
        return "Начать отслеживание ссылки.";
    }

    @Override
    public SendMessage handle(Update update) {
        //String userMessage = update.message().text();
        LOGGER.info("Add link to track in DB");
        return new SendMessage(update.message().chat().id(), "Ссылка отслеживается.");
    }
}
