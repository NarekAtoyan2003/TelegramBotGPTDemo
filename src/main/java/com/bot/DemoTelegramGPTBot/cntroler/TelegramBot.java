package com.bot.DemoTelegramGPTBot.cntroler;

import com.bot.DemoTelegramGPTBot.config.BotConfig;
import com.bot.DemoTelegramGPTBot.service.TelegramBotService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    @Autowired
    private TelegramBotService telegramBotService;
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
            SendMessage patasxan = telegramBotService.patasxan(update);
            execute(patasxan);
        }
    }
}
