package Lesson002.circles;

import Lesson002.common.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindow extends JFrame implements CanvasRepaintListener, MouseListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final int startItem = 10;
    private int count = 0;
    private final Interactable[] sprites = new Interactable[15];

    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        sprites[0] = new Background();
        for (int i = 1; i < startItem; i++) {
            sprites[i] = new Ball();
        }

        MainCanvas canvas = new MainCanvas(this);
        canvas.addMouseListener(this);
        add(canvas);
        setVisible(true);
    }
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }
    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < (startItem + count); i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }
    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < (startItem + count); i++) {
            sprites[i].render(canvas,g);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println(count);
        if(e.getModifiersEx() == 0 && count < 4 && count >= -9) {
            sprites[startItem + count] = new Ball();
            count++;
        } else if ((e.getModifiersEx() == 256 && count <= 4 && count > -9)) {
            sprites[startItem + count] = null;
            count--;
        } else {
            new Exceptional();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
