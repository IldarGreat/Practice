package ru.ssau.tk.ildar.Practice.network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SocketsClientSide {

    public static void main(String[] args) throws IOException {

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("localhost", 8181), 1000);
            Scanner scanner = new Scanner(socket.getInputStream());
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

}
