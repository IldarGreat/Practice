package ru.ssau.tk.ildar.Practice.games.stardew;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.io.Serializable;

public class Game extends Canvas implements Runnable, Serializable {
    @Serial
    private static final long serialVersionUID = -5117184659502625135L;
    public static final int WIDTH = 160;
    public static final int HEIGHT = WIDTH / 4 * 3;
    public static final int SCALE = 3;
    public static final String NAME = "Stardew birthday!";
    private final JFrame frame;

    public Game() {
        setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        frame = new JFrame(NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void run() {

    }
}
