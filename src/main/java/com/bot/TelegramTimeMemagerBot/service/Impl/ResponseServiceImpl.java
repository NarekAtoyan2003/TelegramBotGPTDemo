package com.bot.TelegramTimeMemagerBot.service.Impl;

import com.bot.TelegramTimeMemagerBot.cntroler.TelegramBot;
import com.bot.TelegramTimeMemagerBot.enams.Stadia;
import com.bot.TelegramTimeMemagerBot.model.User;
import com.bot.TelegramTimeMemagerBot.service.ResponseService;
import com.bot.TelegramTimeMemagerBot.service.UserService;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    private TelegramBot telegramBot;

    @Override
    public void responseStart (User user, Boolean bool) throws TelegramApiException {
        if (bool) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(user.getId().toString());
            sendMessage.setText("");
            telegramBot.setResponseService(sendMessage);
        }
    }
}
