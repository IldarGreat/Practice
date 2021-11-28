package ru.ssau.tk.ildar.Practice.network.other;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * В этой программе демонстрируется применение класса InetAddress.'
 * В качестве аргумента в командной строке следует указать имя хоста
 * или же запустить программу без аргументов, чтобы получить в ответ
 * адрес локального хоста
 * ©version 1 2021-11-21
 * ©author Ildar Idiyatov
 */

public class MyInetAddress {

    public static void main(String[] args) throws UnknownHostException {
        if (args.length > 0) {
            for (String host : args) {
                InetAddress[] addresses = InetAddress.getAllByName(host);
                System.out.println("Addresses of host " + host);
                for (InetAddress address : addresses) {
                    System.out.println(address);
                }
            }
        } else {
            System.out.println(InetAddress.getLocalHost());
        }
    }

}

