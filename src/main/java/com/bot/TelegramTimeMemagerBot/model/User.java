package com.bot.TelegramTimeMemagerBot.model;

import com.bot.TelegramTimeMemagerBot.enams.Status;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
public class User {
    private  Long id;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private Status status;
}
