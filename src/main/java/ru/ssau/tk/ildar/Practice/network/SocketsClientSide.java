package ru.ssau.tk.ildar.Practice.network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SocketsClientSide {

    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("time-A.timefreq.bldrdoc.gov",13)){
            socket .setSoTimeout(10000);
            Scanner scanner = new Scanner(socket.getInputStream());
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }
    }
}
