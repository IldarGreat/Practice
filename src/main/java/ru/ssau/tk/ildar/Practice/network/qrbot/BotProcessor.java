package ru.ssau.tk.ildar.Practice.network.qrbot;

import com.google.zxing.WriterException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.ssau.tk.ildar.Practice.network.qrbot.commands.*;
import ru.ssau.tk.ildar.Practice.network.qrbot.exception.UserException;
import ru.ssau.tk.ildar.Practice.network.qrbot.qr.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static ru.ssau.tk.ildar.Practice.network.qrbot.MessageType.*;

/**
 * Основная логика бота программы
 */
@Slf4j
public class BotProcessor extends TelegramLongPollingCommandBot {
    private final static int TEXT_LIMIT = 512;
    private final static BotSettings botSettings = BotSettings.getInstance();
    private static BotProcessor instance;
    private final TelegramBotsApi telegramBotsApi;
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
    public void sendImage(Long chatID, String path) throws UserException {
        try {
            SendPhoto photo = new SendPhoto();
            photo.setPhoto(new InputFile(new File(path)));
            photo.setChatId(chatID.toString());
            execute(photo);
        } catch (TelegramApiException e) {
            log.error(String.format("Sending image error: %s", e.getMessage()));
            throw new UserException("Ошибка отправки изображения");
        }
    }

    /**
     * Отпраляет фото QR изображения в заданый чат
     * отправленное QR изображение удаляется
     *
     * @param chatID ID чата
     * @param path   путь до фото
     */
    public void sendQRImage(Long chatID, String path) throws UserException {
        sendImage(chatID, path);
        File file = new File(path);
        if (!file.delete()) {
            log.error(String.format("Error of removing file %s", path));
            throw new UserException("Ошибка отправки qr кода");
        }
    }

    /**
     * @return имя пользователя бота
     */
    @Override
    public String getBotUsername() {
        return botSettings.getUserName();
    }

    /**
     * Действие при отправке боту некоректной команды.
     * Отправляет пользователю список доступных команд
     *
     * @param update представляет входящее обновление(действие, совершенное с ботом - например, получения сообщение ботом
     */
    @Override
    protected void processInvalidCommandUpdate(Update update) {
        String command = update.getMessage().getText().substring(1);
        sendMessage(
                update.getMessage().getChatId()
                , String.format("Invalid command %s, available commands: %s", command, registeredCommands.toString())
        );
    }

    /**
     * Обрабатывает сообщение пользователя, которое не является командой.
     * Если это изображение, то бот его раскодирует.Если текст, то закодирует.
     *
     * @param update представляет входящее обновление(действие, совершенное с ботом - например, получения сообщение ботом
     */
    @Override
    public void processNonCommandUpdate(Update update) {
        if (update.hasMessage()) {
            try {
                MessageType messageType = getMessageType(update);
                switch (messageType) {
                    case COMMAND -> processInvalidCommandUpdate(update);
                    case IMAGE -> processImage(update);
                    case TEXT -> processText(update);
                }
            } catch (UserException e) {
                sendMessage(update.getMessage().getChatId(), e.getMessage());
            } catch (TelegramApiException | RuntimeException | IOException | WriterException e) {
                log.error(String.format("Received message processing error: %s", e.getMessage()));
                sendMessage(update.getMessage().getChatId(), "Error processing your message");
            }
        }
    }

    /**
     * @return токен бота
     */
    @Override
    public String getBotToken() {
        return botSettings.getToken();
    }

    /**
     * Действие после регистрации бота
     */
    @Override
    public void onRegister() {
        super.onRegister();
    }


    /**
     * Обрабатывает полученный текст от пользователя, в успешном случае отправляет
     * пользователю закодированный QR код текста
     *
     * @param update представляет входящее обновление(действие, совершенное с ботом - например, получения сообщение ботом
     * @throws TelegramApiException бот не может подключиться к серверу
     */
    private void processText(Update update) throws TelegramApiException, IOException, WriterException, UserException {
        String text = update.getMessage().getText();
        logMessage(
                update.getMessage().getChatId(),
                update.getMessage().getFrom().getId(),
                true,
                text);
        if (text.length() > TEXT_LIMIT) {
            log.error(String.format("Message exceeds maximum length of %d", TEXT_LIMIT));
            throw new UserException(String.format("Message exceeds maximum length %d symbols", TEXT_LIMIT));
        }
        String imageUrl = QRTools.encodeText(text);
        logMessage(update.getMessage().getChatId(), update.getMessage().getFrom().getId(), false, "$image");
        sendQRImage(update.getMessage().getChatId(), imageUrl);
    }

    /**
     * Определяет тип отправленого сообщения от пользователя
     *
     * @param update представляет входящее обновление(действие, совершенное с ботом - например, получения сообщение ботом
     * @return тип сообщения
     * @throws UserException если сообщение не является ни текстом, ни изображением
     */
    private MessageType getMessageType(Update update) throws UserException {
        MessageType messageType = null;
        try {
            if (update.getMessage().getPhoto() != null) {
                messageType = MessageType.IMAGE;
            } else if (update.getMessage().getText() != null) {
                messageType = (update.getMessage().getText().matches("^/[\\w]*$")) ?
                        COMMAND :
                        MessageType.TEXT;
            }
            if (messageType == null) {
                throw new IllegalArgumentException(update.toString());
            }
            return messageType;
        } catch (RuntimeException e) {
            log.error(String.format("Invalid message type: %s", e.getMessage()));
            throw new UserException("Invalid message type");
        }
    }

    /**
     * Обрабатывает полученое изображение от пользователя.Декодирует из него информацию
     *
     * @param update update представляет входящее обновление(действие, совершенное с ботом - например, получения сообщение ботом
     * @throws TelegramApiException не получается подключится к серверу
     */
    private void processImage(Update update) throws TelegramApiException, IOException, UserException {
        logMessage(update.getMessage().getChatId(), update.getMessage().getFrom().getId(), true, "$image");
        List<PhotoSize> photoSizes = update.getMessage().getPhoto();
        String fileUrl = getFileUrl(update.getMessage().getPhoto().get(photoSizes.size() - 1).getFileId());
        String text = QRTools.getTextFromQR(fileUrl);
        logMessage(update.getMessage().getChatId(), update.getMessage().getFrom().getId(), false, text);
        sendMessage(update.getMessage().getChatId(), text);
    }

    /**
     * Запрашивает информацию о файле хранилища, возвращает информацию о файле в формате JSON,
     * ссылка на файл хранилища имеет вид: https://api.telegram.org/bot<token>/getFile?file_id=<file_id>,
     * где: token – токен бота, file_id – идентификатор файла.
     *
     * @param fileId ссылка на файл хранилища
     * @return информация о файле в JSON
     */
    private JSONObject getFileRequest(String fileId) throws IOException {
        String fileUrl = String.format("https://api.telegram.org/bot%s/getFile?file_id=%s",
                botSettings.getToken(),
                fileId);
        return IOTools.readJsonFromUrl(fileUrl);
    }

    /**
     * Возвращает ссылку на файл хранилища, для этого сначала запрашиваем информацию о файле (метод getFileRequest),
     * откуда получаем путь к файлу в хранилище (поле «file_path»).
     * Ссылка на файл имеет вид: https://api.telegram.org/file/bot<token>/<path>,
     * где token – токен бота, path – путь к файлу в хранилище.
     *
     * @param fileId ссылка на файл хранилища
     * @return ссылка на файл хранилища
     */
    private String getFileUrl(String fileId) throws IOException {
        JSONObject jsonObject = getFileRequest(fileId);
        return String.format("https://api.telegram.org/file/bot%s/%s",
                botSettings.getToken(),
                jsonObject.get("file_path"));
    }

    private void logMessage(Long chatId, Long userId, boolean input, String text) {
        if (text.length() > TEXT_LIMIT) {
            text = text.substring(0, TEXT_LIMIT);
        }
        log.info(String.format("CHAT [%d] MESSAGE %s %d: %s", chatId, input ? "FROM" : "TO", userId, text));
    }

    /**
     * Регистрирует команды бота
     */
    private void setRegisteredCommands() {
        registeredCommands = getRegisteredCommands()
                .stream()
                .map(IBotCommand::getCommandIdentifier)
                .collect(Collectors.toList());
    }

    private void registerCommands() {
        registerCommands();
        register(new CommandStart());
        register(new CommandHelp());
        setRegisteredCommands();
    }

    /**
     * Подключает бота к Telegram API
     */
    public void registerBot() {
        try {
            telegramBotsApi.registerBot(this);
        } catch (TelegramApiException e) {
            throw new RuntimeException("Telegram API initialization error: " + e.getMessage());
        }
    }

    {
        try {
            telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            registerBot();
            registerCommands();
        } catch (TelegramApiException e) {
            throw new RuntimeException("Telegram Bot initialization error: " + e.getMessage());
        }
    }

    /**
     * Инстанирует объект BotProcessor
     *
     * @return объект BotProcessor
     */
    public static BotProcessor getInstance() {
        if (instance == null)
            instance = new BotProcessor();
        return instance;
    }

    public BotProcessor() {
        super();
    }

}
