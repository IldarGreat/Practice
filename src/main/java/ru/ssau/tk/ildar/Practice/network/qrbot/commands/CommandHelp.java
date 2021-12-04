package ru.ssau.tk.ildar.Practice.network.qrbot.commands;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class CommandHelp extends Command {

    public CommandHelp() {
        super("help", "Help \\help");
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings) {
        message.setText("Функции бота:\n" +
                "-Чтение QR кодов:отправьте изображение QR кода для чтения\n" +
                "-Генерация QR кода:отправьте ссылку или текст"
        );
        super.processMessage(absSender, message, strings);
    }
}
