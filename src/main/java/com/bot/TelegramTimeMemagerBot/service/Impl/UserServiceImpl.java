package com.bot.TelegramTimeMemagerBot.service.Impl;

import com.bot.TelegramTimeMemagerBot.enams.Status;
import com.bot.TelegramTimeMemagerBot.model.User;
import com.bot.TelegramTimeMemagerBot.repository.UserRepository;
import com.bot.TelegramTimeMemagerBot.service.UserService;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResponseServiceImpl responseService;
    @Override
    public void createUser(Long id, String name, String surname) throws TelegramApiException {
        User user = userRepository.getById(id);
        if (user != null) {
            responseService.responseStart(user, false);
        } else {
            user.setId(id);
            user.setName(name);
            user.setSurname(surname);
            user.setStatus(Status.ACTIVE);
            userRepository.save(user);
        }
    }
}
