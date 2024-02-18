package edu.java.bot.UtevBot.Commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class HelpCommand implements Command {

    private static final String HELP_TEXT = """
        UtevBot - справка.

        UtevBot - бот для отслеживания обновлений на разных сайтах.

        Бот содержит 5 команд:
        1. /start -- зарегистрировать пользователя.
        2. /help -- вывести окно с командами.
        3. /track -- начать отслеживание ссылки.
        4. /untrack -- прекратить отслеживание ссылки.
        5. /list -- показать список отслеживаемых ссылок.
        """;

    @Override
    public String command() {
        return "/help";
    }

    @Override
    public String description() {
        return "Получить справку по использованию бота.";
    }

    @Override
    public SendMessage handle(Update update) {
        return new SendMessage(update.message().chat().id(), HELP_TEXT);
    }
}
