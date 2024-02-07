package HomeWork001.client;

import HomeWork001.server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;


public class ClientWindow extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final String[] dataLogin = {"admin","Nick","Poll","Mary","Kris"};
    private final JTextArea log = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2,3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfIPort = new JTextField("8189");
    private final JComboBox<String> tfLogin = new JComboBox<String>(dataLogin);
    private final JPasswordField tfPassword = new JPasswordField("12345");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private String name;
    private boolean clientLogin = false;

    public ClientWindow(ServerWindow serverWindow) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH,HEIGHT);
        setTitle("Chat Client");

        panelTop.add(tfIPAddress);
        panelTop.add(tfIPort);
        panelTop.add(new JLabel());
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = (String) tfLogin.getSelectedItem();
                if (serverWindow.checkWorkServer() && !clientLogin) {
                    serverWindow.loginPerson(name);
                    log.setText(log.getText() + "Вы успешно подключились!\n");
                    clientLogin = true;
                    panelTop.setVisible(false);
                } else if (clientLogin) {
                    log.setText(log.getText() + "Вы успешно отключились!\n");
                    clientLogin = false;
                    panelTop.setVisible(true);
                    return;
                } else {
                    log.setText(log.getText() + "Сервер недоступен!\n");
                    clientLogin = false;
                    panelTop.setVisible(true);
                    return;
                }

                try(FileReader in = new FileReader("HomeWork001/server/log.txt");
                    BufferedReader reader = new BufferedReader(in)) {
//                    while (true) {
                        while (reader.ready()) {
                            String line = reader.readLine();
                            log.setText(log.getText() + line + "\n");
                        }
//                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
                }
            }
        });
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clientLogin) {
                    if (serverWindow.checkWorkServer()) {
//                        serverWindow.loginPerson(name);
                        serverWindow.addMessage(name, tfMessage.getText());
                        log.setText(log.getText() + tfLogin.getSelectedItem() + ": " + tfMessage.getText() + "\n");
                        tfMessage.setText("");
                    } else {
                        log.setText(log.getText() + "Сервер недоступен!\n");
                        panelTop.setVisible(true);
                    }
                } else {
                    log.setText(log.getText() + "Вы не авторизировались!\n");
                }
            }
        });
        tfMessage.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (clientLogin) {
                        if (serverWindow.checkWorkServer()) {
//                        serverWindow.loginPerson(name);
                            serverWindow.addMessage(name, tfMessage.getText());
                            log.setText(log.getText() + tfLogin.getSelectedItem() + ": " + tfMessage.getText() + "\n");
                            tfMessage.setText("");
                        } else {
                            log.setText(log.getText() + "Сервер недоступен!\n");
                            panelTop.setVisible(true);
                        }
                    } else {
                        log.setText(log.getText() + "Вы не авторизировались!\n");
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setVisible(true);
    }
}
