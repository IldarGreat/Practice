package ru.ssau.tk.ildar.Practice.games.stardew;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
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
    private boolean running = false;
    public int ticksCount = 0;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public Game() {
        setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        frame = new JFrame(NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public synchronized void start() {
        running = true;
        new Thread(this).start();
    }

    public synchronized void stop() {
        running = false;
    }

    /**
     * Обновляет игру , все внутренние переменные , логику игры
     */
    public void tick() {
        ticksCount++;
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if(bs ==null){
            createBufferStrategy(3);
            return;
        }
        Graphics graphics = bs.getDrawGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,getWidth(),getHeight());
        graphics.dispose();
        bs.show();
    }

    /**
     * В разных системах этот while будет работать по разному,
     * это означает что игра на разных системах будет обновлятся с разной скоростью.
     * Поэтому нужно ограничить эту скорость в 60 обновлений в секунду
     */
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1_000_000_000D / 60D; // Как много нс находится в tick
        int ticks = 0;
        int frames = 0;
        long lastTimer = System.currentTimeMillis();
        double delta = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = true;
            while (delta >= 1) {
                ticks++;
                tick();
                delta--;
                shouldRender = true;
            }
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            frames++;
            render();

            if (System.currentTimeMillis() - lastTimer >= 1000) {
                lastTimer += 1000;
                System.out.println("frames:" + frames + ",ticks: " + ticks);
                frames = 0;
                ticks = 0;
            }
        }
    }

    public static void main(String[] args) {
        new Game().start();
    }
}
