package ru.ssau.tk.ildar.Practice.network;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedEchoHandler implements Runnable {
    Socket socket;

    ThreadedEchoHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
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
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
