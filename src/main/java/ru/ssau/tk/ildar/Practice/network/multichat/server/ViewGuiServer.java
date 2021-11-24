package ru.ssau.tk.ildar.Practice.network.multichat.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewGuiServer {
    private final JFrame jFrame = new JFrame("Запуск сервера");
    private final JTextArea textArea = new JTextArea(10, 40);
    private final JButton buttonStartServer = new JButton("Запустить сервер");
    private final JButton buttonStopServer = new JButton("Остановить сервер");
    private final JPanel jPanel = new JPanel();
    private final Server server;

    public ViewGuiServer(Server server) {
        this.server = server;
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        jFrame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        jPanel.add(buttonStartServer);
        jPanel.add(buttonStopServer);
        jFrame.add(jPanel, BorderLayout.CENTER);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(jFrame.DO_NOTHING_ON_CLOSE);

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                server.startServer();
                System.exit(0);
            }
        });
        jFrame.setVisible(true);
    }


}
