package ru.ssau.tk.ildar.Practice.network.interrupt;

import java.io.IOException;
import java.net.*;

/**
 * Многопоточный сервер, прослушивающий порт 8189 и посылающий
 * клиентам числа, имитируя зависание после передачи 10 чисел
 */

public class Server implements Runnable {

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(8189);
            while (true) {
                Socket socket = server.accept();
                Runnable socketRun = new ServerHandler(socket);
                Thread thread = new Thread(socketRun);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
