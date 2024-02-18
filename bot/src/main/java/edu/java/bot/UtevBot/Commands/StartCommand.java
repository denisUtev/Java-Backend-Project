package edu.java.bot.UtevBot.Commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class StartCommand implements Command {

    @Override
    public String command() {
        return "/start";
    }

    @Override
    public String description() {
        return "Регистрация в боте.";
    }

    @Override
    public SendMessage handle(Update update) {
        LOGGER.info("create new user in DB");
        return new SendMessage(update.message().chat().id(), "Вы зарегистрированы.");
    }
}
