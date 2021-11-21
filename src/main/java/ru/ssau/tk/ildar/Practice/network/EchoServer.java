package ru.ssau.tk.ildar.Practice.network;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * В этой программе реализуется простой сервер, прослушивающий порт
 * 8189 и посылающий обратно клиенту все полученные от него данные
 *
 * @author Ildar Idiyatov
 * @version 1.21 2021-11-21
 */

public class EchoServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(8189)) {
            try (Socket socket = server.accept()) {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                try (Scanner in = new Scanner(inputStream)) {
                    PrintWriter out = new PrintWriter(outputStream, true);
                    out.println("Hello,you are in my server! Enter BYE to exit.");
                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("Echo:" + line);
                        if (line.trim().equals("BYE")) {
                            done = true;
                        }
                    }
                }
            }
        }
    }

}
