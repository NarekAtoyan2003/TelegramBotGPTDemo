package com.bot.TelegramTimeMemagerBot.cntroler;

import com.bot.TelegramTimeMemagerBot.config.BotConfig;
import com.bot.TelegramTimeMemagerBot.service.Impl.RequestServiceImpl;
import com.bot.TelegramTimeMemagerBot.service.Impl.ResponseServiceImpl;
import com.bot.TelegramTimeMemagerBot.service.RequestService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    @Autowired
    private RequestServiceImpl requestService;
    final BotConfig config;
    public TelegramBot (BotConfig config) {
        this.config = config;
    }
    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getBotToken();
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            requestService.request(update);
        }
    }
    public void setResponseService (SendMessage sendMessage) throws TelegramApiException {
       execute(sendMessage);
    }
}
