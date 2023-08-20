package ru.shtamov.demo.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
@Component
public class TestBot extends TelegramLongPollingBot {

    @Value("${bot.token}") private String botToken;
    @Override
    public String getBotUsername() {
        return "test_shtamov_bot";
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {

    }
}
