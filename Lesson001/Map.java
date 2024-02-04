package Lesson001;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private static final Random RANDOM = new Random();
    private final int DOT_PADDING = 5;
    private int gameOverType;
    private boolean isGameOver;
    private boolean isInitialized;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;
    private static final String MSG_DRAW = "Ничья";
    private static final String MSG_WIN_HUMAN = "Победил игрок";
    private static final String MSG_WIN_AI = "Победил компьютер";
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int Empty_DOT = 0;
    private int fieldSizeY = 3;
    private int fieldSizeX = 3;
    private char[][] field;
    private int panelWidth;
    private int panelHeight;
    private int cellHeight;
    private int cellWidth;
    Map() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        isInitialized = false;
    }
    private void update (MouseEvent e) {
        if (isGameOver||!isInitialized) return;
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;
//        System.out.printf("x=%d, y=%d", cellX,cellY);
        if (!isValidCell(cellY,cellX) || !isEmptyCell(cellY,cellX)) return;
        field[cellX][cellY] = HUMAN_DOT;
        if(checkEndGame(HUMAN_DOT,STATE_WIN_HUMAN)) return;
        aiTurn();
        repaint();
        if(checkEndGame(AI_DOT,STATE_WIN_AI));
    }
    private boolean checkEndGame (int dot, int gameOverType) {
        if (checkWin(dot)) {
            this.gameOverType = gameOverType;
            isGameOver = true;
            repaint();
            return true;
        }
        if (isMapFull()) {
            this.gameOverType = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }
    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        System.out.printf("Mode: %d;\nSize: x=%d, y=%d;\nWin Length: %d",
                mode,fSzX,fSzY,wLen);
        initMap();
        isGameOver = false;
        isInitialized = true;
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }
    private void render(Graphics g) {
        if(!isInitialized) return;
        panelWidth = getWidth();
        panelHeight = getHeight();
        cellHeight = panelHeight/3;
        cellWidth = panelWidth/3;

        g.setColor(Color.BLACK);
        for (int h = 0; h < 3; h++) {
            int y = h*cellHeight;
            g.drawLine(0,y,panelWidth,y);
        }
        for (int w = 0; w < 3; w++) {
            int x = w*cellWidth;
            g.drawLine(x,0, x, panelHeight);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[x][y]== Empty_DOT) continue;
                if (field[x][y]== HUMAN_DOT) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x*cellWidth + DOT_PADDING,
                            y*cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING*2,
                            cellHeight - DOT_PADDING*2);

                } else if (field[x][y]== AI_DOT) {
                    g.setColor(Color.RED );
                    g.fillOval(x*cellWidth + DOT_PADDING,
                            y*cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING*2,
                            cellHeight - DOT_PADDING*2);
                } else {
                    throw new RuntimeException("Unexception value");
                }
            }
        }
        if(isGameOver) showMsgGameOver(g);
    }
    private void initMap() {
        fieldSizeY = 3;
        fieldSizeX = 3;
        field = new char [fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = Empty_DOT;
            }
        }
    }
    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }
    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == Empty_DOT;
    }
    private void aiTurn() {
        int x,y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x,y));
        field[y][x] = AI_DOT;
    }
    private boolean checkWin (int c) {
        int check = 0;
        for (int y = 0; y < fieldSizeY; y++) {
            check = 0;
            for (int x = 0; x < fieldSizeY; x++) {
                if(field[x][y]==c) check++;
                if(check==fieldSizeY) return true;
            }
        }


        for (int x = 0; x < fieldSizeY; x++) {
            check = 0;
            for (int y = 0; y < fieldSizeY; y++) {
                if(field[x][y]==c) check++;
                if(check==fieldSizeY) return true;
            }
        }

//        if (field[0][0]==c && field[0][1]==c && field[0][2]==c) return true;
//        if (field[1][0]==c && field[1][1]==c && field[1][2]==c) return true;
//        if (field[2][0]==c && field[2][1]==c && field[2][2]==c) return true;
//
//        if (field[0][0]==c && field[1][0]==c && field[2][0]==c) return true;
//        if (field[0][1]==c && field[1][1]==c && field[2][1]==c) return true;
//        if (field[0][2]==c && field[1][2]==c && field[2][2]==c) return true;

        if (field[0][0]==c && field[1][1]==c && field[2][2]==c) return true;
        if (field[0][2]==c && field[1][1]==c && field[2][0]==c) return true;
        return false;
    }
    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if(field[i][j] == Empty_DOT) return false;
            }
        }
        return true;
    }
    private void showMsgGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,200,getWidth(),70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD,48));
        switch (gameOverType) {
            case STATE_DRAW:
                g.drawString(MSG_DRAW,180,getHeight()/2); break;
            case STATE_WIN_AI:
                g.drawString(MSG_WIN_AI,20,getHeight()/2); break;
            case STATE_WIN_HUMAN:
                g.drawString(MSG_WIN_HUMAN,70,getHeight()/2); break;
            default:
                throw new RuntimeException("Unexception GameOver state");
        }
    }

}
