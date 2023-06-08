package com.bot.TelegramTimeMemagerBot.repository;

import com.bot.TelegramTimeMemagerBot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User getById (Long id);
}
