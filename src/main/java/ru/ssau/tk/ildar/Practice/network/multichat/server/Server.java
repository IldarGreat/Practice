package ru.ssau.tk.ildar.Practice.network.multichat.server;

import ru.ssau.tk.ildar.Practice.network.multichat.connection.Connection;
import ru.ssau.tk.ildar.Practice.network.multichat.connection.Message;
import ru.ssau.tk.ildar.Practice.network.multichat.connection.MessageType;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Server {
    private ServerSocket serverSocket;
    private static ModelGuiServer modelGuiServer;
    private static ViewGuiServer viewGuiServer;
    private static volatile boolean isServerStart = false;

    public static void main(String[] args) {
        Server server = new Server();
        viewGuiServer = new ViewGuiServer(server);
        modelGuiServer = new ModelGuiServer();
        while (true) {
            if (isServerStart) {
                server.acceptClient();
                isServerStart = false;
            }
        }
    }

    private class ServerThread extends Thread {
        private final Socket socket;

        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        private String addUser(Connection connection) {
            while (true) {
                try {
                    connection.sendMessage(new Message(MessageType.REQUEST_NAME_USER));
                    String name = connection.getMessage().getText();
                    if (name != null
                            && !name.isEmpty()
                            && !modelGuiServer.getAllUsers().containsKey(name)) {
                        modelGuiServer.addUser(name, connection);
                        Set<String> allUsers = new HashSet<>();
                        for (Map.Entry<String, Connection> user : modelGuiServer.getAllUsers().entrySet()) {
                            allUsers.add(user.getKey());
                        }
                        connection.sendMessage(new Message(MessageType.NAME_ACCEPTED, allUsers));
                        sendMessageAllUser(new Message(MessageType.USER_ADDED, name));
                        return name;
                    } else {
                        connection.sendMessage(new Message(MessageType.NAME_USED));
                    }
                } catch (IOException | ClassNotFoundException e) {
                    viewGuiServer.refreshDialogWindow("Возникла ошибка при добавлении нового пользователя");
                }
            }
        }

        private void messagesBetweenUsers(Connection connection, String user) {
            while (true) {
                try {
                    Message message = connection.getMessage();
                    if (message.getMessageType() == MessageType.TEXT_MESSAGE) {
                        sendMessageAllUser(new Message(MessageType.TEXT_MESSAGE,
                                user + ":" + message.getText() + "\n"));
                    }
                    if (message.getMessageType() == MessageType.DISABLE_USER) {
                        sendMessageAllUser(new Message(MessageType.DISABLE_USER, user));
                        modelGuiServer.removeUser(user);
                        connection.close();
                        viewGuiServer.refreshDialogWindow("Пользователь " + user + "(" + socket.getRemoteSocketAddress() + ") отключился");
                        break;
                    }
                } catch (IOException | ClassNotFoundException exception) {
                    viewGuiServer.refreshDialogWindow("Ошибка при отправки сообщения пользователем " + user + "\nВероятно пользователь отключён");
                }
            }
        }

        @Override
        public void run() {
            viewGuiServer.refreshDialogWindow("Подключился пользователь " + socket.getRemoteSocketAddress());
            try {
                Connection connection = new Connection(socket);
                messagesBetweenUsers(connection, addUser(connection));
            } catch (IOException exception) {
                viewGuiServer.refreshDialogWindow("Ошибка подключения пользователя " + socket.getRemoteSocketAddress());
            }
        }

    }

    protected void acceptClient() {
        while (true) {
            try {
                new ServerThread(serverSocket.accept()).start();
            } catch (IOException exception) {
                viewGuiServer.refreshDialogWindow("Связь с сервером потеряна");
                break;
            }
        }
    }

    protected void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            isServerStart = true;
            viewGuiServer.refreshDialogWindow("Сервер запущен");
        } catch (IOException exception) {
            viewGuiServer.refreshDialogWindow("Сервер не получилось запустить");
        }
    }

    protected void stopServer() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                for (Map.Entry<String, Connection> user : modelGuiServer.getAllUsers().entrySet()) {
                    user.getValue().close();
                }
                serverSocket.close();
                modelGuiServer.getAllUsers().clear();
                viewGuiServer.refreshDialogWindow("Сервер остановлен");
            } else {
                viewGuiServer.refreshDialogWindow("Не удалось остановить сервер");
            }
        } catch (Exception e) {
            viewGuiServer.refreshDialogWindow("Не удалось запустить сервер!ЧАВО ТЫ НАДЕЛАЛ");
        }
    }

    protected void sendMessageAllUser(Message message) {
        for (Map.Entry<String, Connection> user : modelGuiServer.getAllUsers().entrySet()) {
            try {
                user.getValue().sendMessage(message);
            } catch (IOException e) {
                viewGuiServer.refreshDialogWindow("Не удалось отправить сообщение всем клиентам");
            }
        }
    }
}
