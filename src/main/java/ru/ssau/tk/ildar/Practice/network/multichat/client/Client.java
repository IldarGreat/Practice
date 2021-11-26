package ru.ssau.tk.ildar.Practice.network.multichat.client;

import ru.ssau.tk.ildar.Practice.network.multichat.connection.*;

import java.io.IOException;
import java.net.Socket;


public class Client {
    private Connection connection;
    private static ViewGuiClient viewGuiClient;
    private static ModelGuiClient modelGuiClient;
    private volatile boolean isConnect = false;

    public static void main(String[] args) {
        Client client = new Client();
        viewGuiClient = new ViewGuiClient(client);
        modelGuiClient = new ModelGuiClient();
        while (true) {
            if (client.isConnect) {
                client.nameRegistration();
                client.getMessageFromServer();
                client.setConnect(false);
            }
        }
    }

    protected boolean isConnect() {
        return this.isConnect;
    }

    protected void setConnect(boolean connect) {
        this.isConnect = connect;
    }

    protected void disconnect() {
        try {
            if (isConnect) {
                connection.sendMessage(new Message(MessageType.DISABLE_USER));
                modelGuiClient.getUsers().clear();
                isConnect = false;
                viewGuiClient.refreshListUsers(modelGuiClient.getUsers());
            } else {
                viewGuiClient.errorMessage("Вы уже отключены!");
            }
        } catch (Exception e) {
            viewGuiClient.errorMessage("Произошла ошибка при отключении");
        }
    }

    protected void connect() {
        if (!isConnect) {
            while (true) {
                try {
                    connection = new Connection(
                            new Socket(viewGuiClient.outputServerAddress(), viewGuiClient.outputServerPort()));
                    isConnect = true;
                    viewGuiClient.addMessage("Вы подключились к серверу!\n");
                    break;
                } catch (Exception e) {
                    viewGuiClient.errorMessage("Ошибка подключения,возможно вы ввели не верный адрес или порт");
                    break;
                }
            }
        } else {
            viewGuiClient.errorMessage("Вы уже подключены!");
        }
    }

    /**
     * Отправка сообщения другим пользователям на сервер
     *
     * @param message текст сообщения
     */
    protected void sendMessageOnServer(String message) {
        try {
            connection.sendMessage(new Message(MessageType.TEXT_MESSAGE, message));
        } catch (IOException exception) {
            viewGuiClient.errorMessage("Ошибка при отправке сообщения");
        }
    }

    /**
     * Метод принимающий сообщения от других клиентов на сервере
     */
    protected void getMessageFromServer() {
        while (isConnect) {
            try {
                Message message = connection.getMessage();

                if (message.getMessageType() == MessageType.TEXT_MESSAGE) {
                    viewGuiClient.addMessage(message.getText());
                }

                if (message.getMessageType() == MessageType.USER_ADDED) {
                    modelGuiClient.addUser(message.getText());
                    viewGuiClient.refreshListUsers(modelGuiClient.getUsers());
                    viewGuiClient.addMessage("Пользователь " + message.getText() + " подключился к серверу\n");
                }

                if (message.getMessageType() == MessageType.DISABLE_USER) {
                    modelGuiClient.removeUser(message.getText());
                    viewGuiClient.refreshListUsers(modelGuiClient.getUsers());
                    viewGuiClient.addMessage("Пользователь " + message.getText() + " отключился\n");
                }
            } catch (Exception e) {
                viewGuiClient.errorMessage("Ошибка при получении сообщения от сервера");
                setConnect(false);
                break;
            }
        }
    }

    protected void nameRegistration() {
        while (true) {
            try {
                Message message = connection.getMessage();

                if (message.getMessageType() == MessageType.REQUEST_NAME_USER) {
                    connection.sendMessage(new Message(
                            MessageType.USER_NAME, viewGuiClient.outputUserName()
                    ));
                }

                if (message.getMessageType() == MessageType.NAME_USED) {
                    viewGuiClient.errorMessage("Данное имя уже используется.Введите другое");
                    connection.sendMessage(new Message(
                            MessageType.USER_NAME, viewGuiClient.outputUserName()
                    ));
                }

                if (message.getMessageType() == MessageType.NAME_ACCEPTED) {
                    viewGuiClient.addMessage("Ваше имя зарегестрировано\n");
                    modelGuiClient.setUsers(message.getAllUsers());
                    break;
                }
            } catch (Exception e) {
                viewGuiClient.errorMessage("Ошибка при регистрации имени.Попробуйте переподключиться");
                try {
                    connection.close();
                    isConnect = false;
                    break;
                } catch (IOException exception) {
                    viewGuiClient.errorMessage("Ошибка при закрытии соединении");
                }
            }
        }
    }
}
