package ru.ssau.tk.ildar.Practice.network;

public class InetAddress {

    public static void main(String[] args) {
        if (args.length > 0){
            String host = args[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
             for (InetAddress a : addresses)
                 System.out.println(a);
             }else
             {
             InetAddress localHostAddress = InetAddress.getLocalHost() ;
             System.out.println(localHostAddress);
             }
        }

    }

