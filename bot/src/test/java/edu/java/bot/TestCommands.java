package edu.java.bot;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import edu.java.bot.UtevBot.Commands.Command;
import edu.java.bot.UtevBot.Commands.HelpCommand;
import edu.java.bot.UtevBot.Commands.ListCommand;
import edu.java.bot.UtevBot.Commands.StartCommand;
import edu.java.bot.UtevBot.Commands.TrackCommand;
import edu.java.bot.UtevBot.Commands.UntrackCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TestCommands {

    @Mock
    private Update update;
    @Mock
    private Message message;
    @Mock
    private Chat chat;

    @BeforeEach
    public void setUp() {
        Long  chatId = 256L;
        Mockito.doReturn(message).when(update).message();
        Mockito.doReturn(chat).when(message).chat();
        Mockito.doReturn(chatId).when(chat).id();

        //Mockito.doReturn(chat).when(message).chat();
        //Mockito.doReturn(chatId).when(chat).id();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест команды /start")
    void testStartCommand() {
        Command startCommand = new StartCommand();
        Mockito.doReturn(message).when(update).message();
        Mockito.when(update.message().text()).thenReturn("/start");
        assertTrue(startCommand.supports(update));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест команды /help")
    void testHelpCommand() {
        Command helpCommand = new HelpCommand();
        Mockito.doReturn(message).when(update).message();
        Mockito.when(update.message().text()).thenReturn("/help");
        assertTrue(helpCommand.supports(update));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест команды /list")
    void testListCommand() {
        Command listCommand = new ListCommand();
        Mockito.doReturn(message).when(update).message();
        Mockito.when(update.message().text()).thenReturn("/list");
        assertTrue(listCommand.supports(update));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест команды /track")
    void testTrackCommand() {
        Command trackCommand = new TrackCommand();
        Mockito.doReturn(message).when(update).message();
        Mockito.when(update.message().text()).thenReturn("/track");
        assertTrue(trackCommand.supports(update));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест команды /untrack")
    void testUntrackCommand() {
        Command untrackCommand = new UntrackCommand();
        Mockito.doReturn(message).when(update).message();
        Mockito.when(update.message().text()).thenReturn("/untrack");
        assertTrue(untrackCommand.supports(update));
    }

}
