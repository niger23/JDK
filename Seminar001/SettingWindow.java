package Seminar001;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;

    JButton btnStart;
    private JSlider changeSize, changeSizeWin;

    SettingWindow(GameWindow gameWindow){
        setTitle("Setting");
        btnStart = new JButton("Start new game");

        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                gameWindow.startNewGame(0, 3, 3, 3);
            }
        });
        JPanel settingPanel = new JPanel(new GridLayout(3,1));
        settingPanel.add(getModePanel());
        settingPanel.add(getSizePanel());
        settingPanel.add(getSizeWinPanel());
        add(settingPanel);
        add(btnStart, BorderLayout.SOUTH);
    }
    private JPanel getModePanel() {
        JPanel getModePanel = new JPanel(new GridLayout(3,1));
        JLabel textTitle = new JLabel("Выберите режим игры: ");
        JRadioButton humanMode = new JRadioButton("игрок против игрока");
        JRadioButton aiMode = new JRadioButton("игрок против компьютера");
        ButtonGroup changeMode = new ButtonGroup();
        aiMode.setSelected(true);
        changeMode.add(humanMode);
        changeMode.add(aiMode);
        getModePanel.add(textTitle);
        getModePanel.add(humanMode);
        getModePanel.add(aiMode);
        return getModePanel;
    }
    private JPanel getSizePanel() {
        String size = "Установленный размер поля: ";
        JPanel sizePanel = new JPanel(new GridLayout(3,1));
        JLabel textTitle = new JLabel("Выберите размер поля: ");
        changeSize = new JSlider(3,10,3);

        JLabel textChange = new JLabel(size + changeSize.getValue());
        changeSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textChange.setText(size + changeSize.getValue());
                changeSizeWin.setMaximum(changeSize.getValue());
            }
        });
        sizePanel.add(textTitle);
        sizePanel.add(textChange);
        sizePanel.add(changeSize);
        return sizePanel;
    }
    private JPanel getSizeWinPanel() {
        String size = "Выигрышная комбинация: ";
        JPanel sizePanel = new JPanel(new GridLayout(3,1));
        JLabel textTitle = new JLabel("Выберите размер для победы: ");
        changeSizeWin = new JSlider(3,10,3);
        JLabel textChange = new JLabel(size + changeSizeWin.getValue());
        changeSizeWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textChange.setText(size + changeSizeWin.getValue());
            }
        });
        sizePanel.add(textTitle);
        sizePanel.add(textChange);
        sizePanel.add(changeSizeWin);
        return sizePanel;
    }
}
