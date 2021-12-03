package ru.ssau.tk.ildar.Practice.network.qrbot.commands;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class CommandStart extends Command {

    public CommandStart() {
        super("start", "Bot launch");
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings) {
        message.setText("Welcome!\n" +
                "@QRDetectorBot greets you, I have two functions:\n" +
                "reading and generating QR codes"
        );
        super.processMessage(absSender, message, strings);
    }
}