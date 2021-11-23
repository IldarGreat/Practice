package ru.ssau.tk.ildar.Practice.network.multichat.connection;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

public class Message implements Serializable {
    @Serial
    private static final long serialVersionUID = -1675944781705268531L;
    private final MessageType messageType;
    private final String textArea;
    private final Set<String> allUsers;

    public Message(MessageType messageType, String textArea) {
        this.messageType = messageType;
        this.textArea = textArea;
        this.allUsers = null;
    }

    public Message(MessageType messageType, Set<String> allUsers) {
        this.messageType = messageType;
        this.allUsers = allUsers;
        this.textArea = null;
    }

    public Message(MessageType messageType) {
        this.messageType = messageType;
        this.textArea = null;
        this.allUsers = null;
    }

    public MessageType getMessageType() {
        return this.messageType;
    }

    public String getTextArea() {
        return this.textArea;
    }

    public Set<String> getAllUsers() {
        return this.allUsers;
    }
}
