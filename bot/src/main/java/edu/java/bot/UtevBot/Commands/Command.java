package edu.java.bot.UtevBot.Commands;

import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Command {

    Logger LOGGER = LogManager.getLogger();
    String command();

    String description();

    SendMessage handle(Update update);

    default boolean supports(Update update) {
        String text = update.message().text();
        int indexEndCommand = text.length();
        if (text.contains(" ")) {
            indexEndCommand = text.indexOf(" ");
        }
        String calledCommand = text.substring(0, indexEndCommand);
        return command().equals(calledCommand);
    }

    default BotCommand toApiCommand() {
        return new BotCommand(command(), description());
    }
}
