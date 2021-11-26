package ru.ssau.tk.ildar.Practice.network.multichat.client;

import java.util.*;

/**
 * В модели хранится множество подключившихся пользователей
 */
public class ModelGuiClient {
    private Set<String> users = new HashSet<>();

    protected void setUsers(Set<String> users) {
        this.users = users;
    }

    protected void addUser(String name) {
        users.add(name);
    }

    protected void removeUser(String name) {
        users.remove(name);
    }

    protected Set<String> getUsers() {
        return users;
    }
}
