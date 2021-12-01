package ru.ssau.tk.ildar.Practice.network.qrbot.exception;

import java.io.Serial;

public class UserException extends Exception {
    @Serial
    private static final long serialVersionUID = -3586774044585084312L;

    public UserException(String message) {
        super(message);
    }
}
