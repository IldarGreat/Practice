package ru.ssau.tk.ildar.Practice.network.interrupt;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class InterruptibleSocketFrame extends JFrame {
    public static final int TEXT_ROWS = 20;
    public static final int TEXT_COLUMNS = 60;
    private Scanner in;
    private final JButton interruptibleButton;
    private final JButton blockingButton;
    private JButton cancelButton;
    private final JTextArea messages;
    private final Server server;
    private Thread connectThread;

    public InterruptibleSocketFrame() {
        JPanel northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);
        messages = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(messages));
        interruptibleButton = new JButton("Interruptible");
        blockingButton = new JButton("Blocking");
        northPanel.add(interruptibleButton);
        northPanel.add(blockingButton);

        interruptibleButton.addActionListener(e -> {
            interruptibleButton.setEnabled(false);
            blockingButton.setEnabled(false);
            cancelButton.setEnabled(true);
            connectThread = new Thread(() -> {
                try {
                    connectlnterruptibly();
                } catch (IOException exception) {
                    messages.append("\nlnterruptibleSocketTest.connectlnterruptibly: " + exception);
                }
            });
            connectThread.start();
        });

        blockingButton.addActionListener(e -> {
            interruptibleButton.setEnabled(false);
            blockingButton.setEnabled(false);
            cancelButton.setEnabled(true);
            connectThread = new Thread(() -> {
                try {
                    connectBlocking();
                } catch (IOException exception) {
                    messages.append("\nlnterruptibleSocketTest.connectBlocking: " + exception);
                }
            });
            connectThread.start();
        });

        cancelButton = new JButton("Cancel");
        cancelButton.setEnabled(false);
        northPanel.add(cancelButton);
        cancelButton.addActionListener(e -> {
            connectThread.interrupt();
            cancelButton.setEnabled(false);
        });
        server = new Server();
        new Thread(server).start();
        pack();
    }

    /**
     * Соединяет с проверяемым сервером, используя прерываемый ввод-вывод
     */
    public void connectlnterruptibly() throws IOException {
        messages.append("Interruptible:\n");
        try (SocketChannel channel = SocketChannel.open(
                new InetSocketAddress("localhost", 8189))) {
            in = new Scanner(channel);
            while (!Thread.currentThread().isInterrupted()) {
                messages.append("Reading ");
                if (in.hasNextLine()) {
                    String line = in.nextLine();
                    messages.append(line);
                    messages.append("\n");
                }
            }
        } finally {
            EventQueue.invokeLater(() -> {
                messages.append("Channel closed\n");
                interruptibleButton.setEnabled(true);
                blockingButton.setEnabled(true);
            });
        }
    }

    /**
     * Соединяет с проверяемым сервером, используя блокирующий ввод-вывод
     */
    public void connectBlocking() throws IOException {
        messages.append("Blocking:\n");
        try (Socket sock = new Socket("localhost", 8189)) {
            in = new Scanner(sock.getInputStream());
            while (!Thread.currentThread().isInterrupted()) {
                messages.append("Reading ");
                if (in.hasNextLine()) {
                    String line = in.nextLine();
                    messages.append(line);
                    messages.append("\n");
                }
            }
        } finally {
            EventQueue.invokeLater(() -> {
                messages.append("Socket closed\n");
                interruptibleButton.setEnabled(true);
                blockingButton.setEnabled(true);
            });
        }
    }


}
