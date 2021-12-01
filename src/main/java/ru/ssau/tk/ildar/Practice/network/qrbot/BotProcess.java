package ru.ssau.tk.ildar.Practice.network.qrbot;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Основная логика бота программы
 */
@Slf4j
public class BotProcess extends TelegramLongPollingCommandBot {
    private final BotSettings botSettings = BotSettings.getInstance();
    private List<String> registeredCommands = new ArrayList<>();

    /**
     * Отпраляет сообщение в заданый чат
     *
     * @param chatID  ID чата
     * @param message текст сообщения
     */
    public void sendMessage(Long chatID, String message) {
        try {
            SendMessage sendMessage = SendMessage
                    .builder()
                    .chatId(chatID.toString())
                    .text(message)
                    .build();
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(String.format("Sending message error: %s", e.getMessage()));
        }
    }

    /**
     * Отпраляет фото в заданый чат
     *
     * @param chatID ID чата
     * @param path   путь до фото
     */
    public void sendImage(Long chatID, String path) {
        try {
            SendPhoto photo = new SendPhoto();
            photo.setPhoto(new InputFile(new File(path)));
            photo.setChatId(chatID.toString());
            execute(photo);
        } catch (TelegramApiException e) {
            log.error(String.format("Sending image error: %s", e.getMessage()));
        }
    }

    /**
     * Отпраляет фото QR изображения в заданый чат
     * отправленное QR изображение удаляется
     *
     * @param chatID ID чата
     * @param path   путь до фото
     */
    public void sendQRImage(Long chatID, String path) {
        sendImage(chatID, path);
        File file = new File(path);
        if (!file.delete()) {
            log.error(String.format("Error of removing file %s", path));
        }
    }

    /**
     * @return имя пользователя бота
     */
    @Override
    public String getBotUsername() {
        return botSettings.getUserName();
    }

    @Override
    protected void processInvalidCommandUpdate(Update update) {
        String command = update.getMessage().getText().substring(1);
        sendImage(
                update.getMessage().getChatId()
                , String.format("Некоректная команда %s, доступные команды: %s", command, registeredCommands.toString())
        );
    }

    @Override
    public void processNonCommandUpdate(Update update) {

    }

    @Override
    public String getBotToken() {
        return null;
    }
}
