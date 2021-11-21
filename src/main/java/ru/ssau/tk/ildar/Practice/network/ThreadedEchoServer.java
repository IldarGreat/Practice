package ru.ssau.tk.ildar.Practice.network;

import java.io.IOException;
import java.net.*;

/**
 * В этой программе реализуется многопоточный сервер, прослушивающий
 * порт 8190 и передающий обратно все данные, полученные от клиентов
 * ©author Ildar Idiyatov
 * @version 1.21 2021-11-21
 */

public class ThreadedEchoServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8190);
        while (true) {
            Socket socket = server.accept();
            Runnable threadSocket = new ThreadedEchoHandler(socket);
            Thread thread = new Thread(threadSocket);
            thread.start();
        }
    }
}
