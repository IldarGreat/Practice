package ru.ssau.tk.ildar.Practice.network.multichat.server;

import ru.ssau.tk.ildar.Practice.network.multichat.connection.Connection;

import java.util.*;

public class ModelGuiServer {
    Map<String, Connection> allUsers = new HashMap<>();

    protected Map<String, Connection> getAllUsers() {
        return allUsers;
    }

    protected void addUser(String name, Connection connection) {
        allUsers.put(name, connection);
    }

    protected void removeUser(String name) {
        allUsers.remove(name);
    }
}
