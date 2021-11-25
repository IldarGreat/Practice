package ru.ssau.tk.ildar.Practice.network.multichat.server;

import ru.ssau.tk.ildar.Practice.network.multichat.connection.Connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Map;

public class Server {
    private ServerSocket serverSocket;
    private static ModelGuiServer modelGuiServer;
    private static ViewGuiServer viewGuiServer;
    private static volatile boolean isServerStart = false;

    private class ServerThread extends Thread{

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
            if(serverSocket!=null && !serverSocket.isClosed()){
                for(Map.Entry<String, Connection> user : modelGuiServer.getAllUsers().entrySet()){
                    user.getValue().close();
                }
                serverSocket.close();
                modelGuiServer.getAllUsers().clear();
                viewGuiServer.refreshDialogWindow("Сервер остановлен");
            }else {
                viewGuiServer.refreshDialogWindow("Не удалось остановить сервер");
            }
        }catch (Exception e){
            viewGuiServer.refreshDialogWindow("Не удалось запустить сервер!ЧАВО ТЫ НАДЕЛАЛ");
        }
    }
}
