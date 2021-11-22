package ru.ssau.tk.ildar.Practice.network.interrupt;

import javax.swing.*;
import java.awt.*;

public class InterruptibleSocketMain {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new InterruptibleSocketFrame();
            frame.setTitle("InterruptibleSocketMain");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
