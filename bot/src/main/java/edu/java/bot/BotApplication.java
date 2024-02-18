package edu.java.bot;

import edu.java.bot.UtevBot.UtevBot;
import edu.java.bot.configuration.ApplicationConfig;
import lombok.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class BotApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotApplication.class, args);
        //System.out.println(System.getenv("TELEGRAM_API_KEY"));
    }
}
