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
        jFrame.add(new JScrollPane(textArea), BorderLayout.NORTH);
        jPanel.add(buttonStartServer);
        jPanel.add(buttonStopServer);
        jFrame.add(jPanel);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(jFrame.DO_NOTHING_ON_CLOSE);

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                server.stopServer();
                System.exit(0);
            }
        });
        jFrame.setVisible(true);

        buttonStartServer.addActionListener(e -> server.startServer(getPort()));

        buttonStopServer.addActionListener(e -> server.stopServer());
    }

    public void refreshDialogWindow(String message) {
        textArea.append(message);
    }

    protected int getPort() {
        while (true) {
            String port = JOptionPane.showInputDialog(
                    jFrame,
                    "Введите порт сервера:",
                    "Ввод порта сервера:",
                    JOptionPane.QUESTION_MESSAGE
            );
            try {
                return Integer.parseInt(port.trim());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(jFrame,
                        "Введен некоректный порт сервера,попробуйте еще раз",
                        "Некоректный порт",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
