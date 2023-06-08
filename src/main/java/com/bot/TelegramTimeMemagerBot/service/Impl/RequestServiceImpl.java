package com.bot.TelegramTimeMemagerBot.service.Impl;

import com.bot.TelegramTimeMemagerBot.cntroler.TelegramBot;
import com.bot.TelegramTimeMemagerBot.config.BotConfig;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class RequestServiceImpl  {
    @Autowired
    private UserServiceImpl userService;
    public void request (Update update) throws TelegramApiException {
        switch (update.getMessage().getText()) {
            case ("/START") :
                    userService.createUser(update.getMessage().getChatId(),
                            update.getMessage().getChat().getFirstName(),
                            update.getMessage().getChat().getLastName());
                break;
        }
    }
}
