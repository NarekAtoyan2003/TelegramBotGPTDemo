package com.bot.TelegramTimeMemagerBot.service;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface UserService {
    void createUser (Long id, String name, String surname) throws TelegramApiException;
}
