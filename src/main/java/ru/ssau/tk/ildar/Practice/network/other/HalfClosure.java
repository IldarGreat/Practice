package ru.ssau.tk.ildar.Practice.network.other;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class HalfClosure {

    public static void main(String[] args) throws IOException {
        try(ServerSocket server = new ServerSocket(8189)){
            try(Socket socket = server.accept()){
                try(Scanner in = new Scanner(socket.getInputStream())){
                    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                    out.println("We need information");
                    socket.shutdownOutput();
                    while(in.hasNextLine()){
                        System.out.println("We get information");
                    }
                }
            }
        }
    }
}
