package Lesson002.common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exceptional extends JFrame implements Thread.UncaughtExceptionHandler {
    public Exceptional() {
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setBounds(1100,200,500,300);
//        JButton btn = new JButton("Push me!");
//        btn.addActionListener(this);
        Thread.setDefaultUncaughtExceptionHandler(this);
        throw new ArrayIndexOutOfBoundsException("Мячей не может быть больше 13 или меньше 0");
//        add(btn, BorderLayout.NORTH);
//        setVisible(true);
    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        throw new ArrayIndexOutOfBoundsException("Bad thing happened");
//    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        JOptionPane.showMessageDialog(null, e.getMessage(),
                "Ошибочка!", JOptionPane.ERROR_MESSAGE);
    }


}
