package ru.shtamov.demo.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.shtamov.demo.service.VideoUrlServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class TestBot extends TelegramLongPollingBot {

    private static final Logger LOG = LoggerFactory.getLogger(TestBot.class);
    private static final String START = "/start";

    @Value("${bot.token}")
    private String botToken;
    private final VideoUrlServiceImpl videoUrlService;
    @Autowired
    public TestBot(VideoUrlServiceImpl videoUrlService) {
        this.videoUrlService = videoUrlService;
    }

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
        String text = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();

        if(text.equals(START)){
            String userName = update.getMessage().getChat().getUserName();
            startCommand(chatId, userName);
        }
        else {
            urlCommand(chatId, text);
        }

    }

    private void startCommand(long chatId, String userName) {
        var text = """
                Добро пожаловать в бот, %s!
                
                Это тестовый запуск бота Алексея Штамова.
                
                Пока он ничего не умеет!
                """;
        var formattedText = String.format(text, userName);
        sendMessage(chatId, formattedText);
    }

    private void urlCommand(long chatId, String realsUrl){

        String videourl = videoUrlService.getVideoUrl(realsUrl);
        sendMessage(chatId, videourl);
    }

    private void sendMessage(Long chatId, String text) {
        var chatIdStr = String.valueOf(chatId);
        var sendMessage = new SendMessage(chatIdStr, text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            LOG.error("Ошибка отправки сообщения", e);
        }
    }
}
