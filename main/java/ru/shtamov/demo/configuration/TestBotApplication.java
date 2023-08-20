package ru.shtamov.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.shtamov.demo.bot.TestBot;

@Configuration
public class TestBotApplication {

    @Bean
    public TelegramBotsApi telegramBotsApi(TestBot testBot) throws TelegramApiException {
        var api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(testBot);
        return api;
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
