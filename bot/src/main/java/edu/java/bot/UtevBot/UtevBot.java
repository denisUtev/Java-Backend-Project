package edu.java.bot.UtevBot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SetMyCommands;
import edu.java.bot.UtevBot.ResponceService.ResponseService;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UtevBot  implements UpdatesListener {

    TelegramBot bot;
    private final ResponseService responseService;

    public UtevBot() {
        bot = new TelegramBot(System.getenv("TELEGRAM_API_KEY"));
        responseService = new ResponseService();
        start();
    }

    public void start() {
        bot.execute(createMenu());
        bot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> list) {
        for (var update : list) {
            //System.out.println(update.message().chat());
            bot.execute(responseService.getAnswer(update));
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private SetMyCommands createMenu() {
        return new SetMyCommands();
    }
}
