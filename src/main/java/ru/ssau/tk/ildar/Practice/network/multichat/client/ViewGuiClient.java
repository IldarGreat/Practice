package ru.ssau.tk.ildar.Practice.network.multichat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

public class ViewGuiClient {
    private final Client client;
    private final JFrame jFrame = new JFrame("Чат");
    private final JTextArea messages = new JTextArea(30, 20);
    private final JTextArea users = new JTextArea(30, 15);
    private final JPanel jPanel = new JPanel();
    private final JTextField text = new JTextField(40);
    private final JButton connectButton = new JButton("Подключиться");
    private final JButton disconnectButton = new JButton("Отключиться");

    public ViewGuiClient(Client client) {
        this.client = client;
        messages.setEditable(false);
        users.setEditable(false);
        jFrame.add(new JScrollPane(messages), BorderLayout.CENTER);
        jFrame.add(new JScrollPane(users), BorderLayout.EAST);
        jPanel.add(text);
        jPanel.add(connectButton);
        jPanel.add(disconnectButton);
        jFrame.add(jPanel, BorderLayout.SOUTH);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (client.isConnect()) {
                    client.disconnect();
                }
                System.exit(0);
            }
        });
        jFrame.setVisible(true);
        connectButton.addActionListener(e -> client.connect());
        disconnectButton.addActionListener(e -> client.disconnect());
        text.addActionListener(e -> {
            client.sendMessageOnServer(text.getText());
            text.setText("");
        });
    }

    protected void addMessage(String text) {
        messages.append(text);
    }

    /**
     * Обновляет список имен подключившихся пользователей в графическом виде
     *
     * @param currentUsers множество подключившихся пользователей
     */
    protected void refreshListUsers(Set<String> currentUsers) {
        users.setText("");
        if (client.isConnect()) {
            StringBuilder usersInformation = new StringBuilder("Список пользователей:\n");
            for (String user : currentUsers) {
                usersInformation
                        .append(user)
                        .append("\n");
            }
            users.append(usersInformation.toString());
        }
    }

    /**
     * Вызывает окно для ввода IP сервера
     *
     * @return адрес сервера
     */
    protected String outputServerAddress() {
        while (true) {
            String addressServer = JOptionPane.showInputDialog(
                    jFrame,
                    "Введите адрес сервера",
                    "Ввод адреса сервера",
                    JOptionPane.QUESTION_MESSAGE
            );
            return addressServer.trim();
        }
    }

    /**
     * Вызывает окно для ввода порта сервера
     *
     * @return порт сервера
     */
    protected int outputServerPort() {
        while (true) {
            try {
                String portServer = JOptionPane.showInputDialog(
                        jFrame,
                        "Введите порт сервера",
                        "Ввод порта сервера",
                        JOptionPane.QUESTION_MESSAGE
                );
                return Integer.parseInt(portServer.trim());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        jFrame,
                        "Введен некоректный порт сервера.Попробуйте еще раз",
                        "Ошибка порта",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    /**
     * Вызывает окно для ввода имени пользователя
     *
     * @return имя пользователя
     */
    protected String outputUserName() {
        String userName = JOptionPane.showInputDialog(
                jFrame,
                "Введите имя пользователя",
                "Ввод имени пользователя",
                JOptionPane.QUESTION_MESSAGE
        );
        return userName.trim();
    }

    /**
     * Вызывает окно ошибки с заданным текстом
     *
     * @param text Объяснение ошибки
     */
    protected void errorMessage(String text) {
        JOptionPane.showMessageDialog(
                jFrame,
                text,
                "Ошибка",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
