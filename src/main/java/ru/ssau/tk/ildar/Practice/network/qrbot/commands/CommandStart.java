package ru.ssau.tk.ildar.Practice.network.qrbot.commands;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class CommandStart extends Command {

    public CommandStart() {
        super("start", "Bot launch");
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings) {
        message.setText("Привествую!\n" +
                "я @QRDetectorBot, и у меня есть 2 функции:\n" +
                "чтение и запись QR кодов"
        );
        super.processMessage(absSender, message, strings);
    }
}
