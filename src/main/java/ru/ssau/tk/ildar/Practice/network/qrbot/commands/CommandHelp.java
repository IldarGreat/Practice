package ru.ssau.tk.ildar.Practice.network.qrbot.commands;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class CommandHelp extends Command {

    public CommandHelp() {
        super("help", "Help \\help");
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings) {
        message.setText("Bot functions:\n" +
                "-Reading QR codes:send the image of the QR code to read\n" +
                "-Generation QR codes:send a link or text to generate"
        );
        super.processMessage(absSender, message, strings);
    }
}
