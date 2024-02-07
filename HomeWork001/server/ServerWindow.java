package HomeWork001.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ServerWindow extends JFrame {
    private File chatlog;
    private PrintWriter pw;
    private static final int POS_X = 500;
    private static final int POS_Y = 500;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    private boolean isServerWorking;
    public ServerWindow() {
        isServerWorking = false;
        JPanel btnPanel = new JPanel(new GridLayout(1,2));
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    isServerWorking = true;
                    log.setText(log.getText() + "Сервер запущен!\n");
                    try(FileReader in = new FileReader("HomeWork001/server/log.txt");
                        BufferedReader reader = new BufferedReader(in)) {
                        while (reader.ready()) {
                            String line = reader.readLine();
                            log.setText(log.getText() + line + "\n");
                        }
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    log.setText(log.getText() + "Сервер уже запущен!\n");
                }
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    isServerWorking = false;
                    log.setText(log.getText() + "Сервер остановлен!\n");
                } else {
                    log.setText(log.getText() + "Сервер уже остановлен!\n");
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH,HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        btnPanel.add(btnStart);
        btnPanel.add(btnStop);
        add(log);
        add(btnPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    public void loginPerson (String name) {
        log.setText(log.getText() + name + " подключился к беседе\n");
    }
    public boolean checkWorkServer () {
        return isServerWorking;
    }
    public void addMessage (String name, String msg) {
        try(FileWriter writer = new FileWriter("HomeWork001/server/log.txt", true)) {
            chatlog = new File("HomeWork001/server/log.txt");
            if (!chatlog.exists()) {
                chatlog.createNewFile();
            }
            writer.write(name + ": " + msg + "\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.setText(log.getText() + name + ": " + msg + "\n");

    }

}
