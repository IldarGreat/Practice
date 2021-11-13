package ru.ssau.tk.ildar.Practice.viruses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

public class SimpleVirus {
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static void blockAll() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_0);
        robot.mouseMove(new Random().nextInt((int) screenSize.getWidth()), new Random().nextInt((int) screenSize.getHeight()));
    }


    public static String message() {
        List<String> messages = new ArrayList<>();
        messages.add("it is near");
        messages.add("it is somewhere here");
        messages.add("do you hear?");
        messages.add("it will come soon");
        messages.add("fear");
        messages.add("it sneaks");
        messages.add("who are you?");
        messages.add("come with me");
        return messages.get(new Random().nextInt(8));
    }

    public static void popUp() {
        JWindow jWindow = new JWindow();
        JLabel jLabel = new JLabel(message(), JLabel.CENTER);
        jWindow.add(jLabel);
        jWindow.setSize(150, 50);
        jWindow.setLocation(new Random().nextInt((int) screenSize.getWidth()), new Random().nextInt((int) screenSize.getHeight()));
        jWindow.setVisible(true);
    }

    public static void main(String[] args) throws AWTException {
        for(int i=0;i<1000;i++) {
            blockAll();
            popUp();
        }
    }
}
