package edu.java.bot.UtevBot.Commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import java.util.ArrayList;
import java.util.List;

public class ListCommand implements Command {

    private static final String ANSWER_EMPTY_LIST = "Ваш список пуст";
    private static final String DEFAULT_ANSWER = "Ваш список:\n";

    @Override
    public String command() {
        return "/list";
    }

    @Override
    public String description() {
        return "Показать список отслеживаемых ссылок.";
    }

    @Override
    public SendMessage handle(Update update) {
        //String userMessage = update.message().text();
        List<String> links = new ArrayList<>();
        LOGGER.info("get user links from DB");
        return new SendMessage(update.message().chat().id(), getLinksList(links));
    }

    public String getLinksList(List<String> links) {
        if (links.isEmpty()) {
            return ANSWER_EMPTY_LIST;
        }
        StringBuilder answerText = new StringBuilder(DEFAULT_ANSWER);
        for (String link : links) {
            answerText.append(link).append("\n");
        }
        return answerText.toString();
    }
}
