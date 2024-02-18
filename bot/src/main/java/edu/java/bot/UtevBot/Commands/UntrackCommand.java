package edu.java.bot.UtevBot.Commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class UntrackCommand implements Command {

    @Override
    public String command() {
        return "/untrack";
    }

    @Override
    public String description() {
        return "Прекратить отслеживание ссылки.";
    }

    @Override
    public SendMessage handle(Update update) {
        //String userMessage = update.message().text();
        LOGGER.info("set untrack link in DB");
        return new SendMessage(update.message().chat().id(), "Ссылка перестала отслеживаться.");
    }
}
