package ru.ssau.tk.ildar.Practice.network.qrbot;

import lombok.extern.slf4j.Slf4j;
import ru.ssau.tk.ildar.Practice.network.qrbot.bot.BotProcessor;

@Slf4j
public class Main {

    public static void main(String[] args) {
        try {
            BotProcessor botProcessor = BotProcessor.getInstance();
            log.info("Telegram bot started");
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
        }
    }
}
