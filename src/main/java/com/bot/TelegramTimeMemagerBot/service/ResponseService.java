package com.bot.TelegramTimeMemagerBot.service;

import com.bot.TelegramTimeMemagerBot.enams.Stadia;
import com.bot.TelegramTimeMemagerBot.model.User;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface ResponseService {
    void responseStart (User user, Boolean bool) throws TelegramApiException;
}