package ru.ssau.tk.ildar.Practice.network;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketsServerSide {

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8181)) {
            Socket socket = serverSocket.accept();
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("Commands:\nInformation\nExit");
            while (scanner.hasNextLine()) {
                String information = scanner.nextLine();
                switch (information) {
                    case "Hi" -> printWriter.println("Hi,there!!");
                    case "Information" -> printWriter.println("Port:" + serverSocket.getLocalPort()
                    +"\nIP:"+ serverSocket.getInetAddress());
                    case "Exit" -> {}
                    default -> printWriter.println("Unknown command");
                }
                if (information.equals("Exit")) {
                    break;
                }
            }

        }
    }

}
