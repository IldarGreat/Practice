package ru.ssau.tk.ildar.Practice.network.interrupt;

import java.io.*;
import java.net.Socket;

/**
 * Этот класс обрабатывает данные, получаемые сервером
 * от клиента через одно сокетное соединение
 */
public class ServerHandler implements Runnable {
    private final Socket socket;
    private int count;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                while (count < 100) {
                    count++;
                    if (count <= 10) out.println(count);
                    Thread.sleep(100);
                }
            } finally {
                socket.close();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
