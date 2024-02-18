package edu.java.bot.UtevBot.ResponceService;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.UtevBot.Commands.Command;
import edu.java.bot.UtevBot.Commands.HelpCommand;
import edu.java.bot.UtevBot.Commands.ListCommand;
import edu.java.bot.UtevBot.Commands.StartCommand;
import edu.java.bot.UtevBot.Commands.TrackCommand;
import edu.java.bot.UtevBot.Commands.UntrackCommand;
import java.util.ArrayList;
import java.util.List;

public class ResponseService {

    private static final String NOT_FOUND_COMMAND = "Команда не найдена";
    List<Command> commandList = new ArrayList<>();

    public ResponseService() {
        commandList.add(new StartCommand());
        commandList.add(new HelpCommand());
        commandList.add(new TrackCommand());
        commandList.add(new UntrackCommand());
        commandList.add(new ListCommand());
    }

    public SendMessage getAnswer(Update update) {
        for (Command command : commandList) {
            if (command.supports(update)) {
                return command.handle(update);
            }
        }
        return new SendMessage(update.message().chat().id(), NOT_FOUND_COMMAND);
        //return new SendMessage(update.message().chat().id(), update.message().text());
    }
}
