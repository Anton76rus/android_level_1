package ru.geekbrains.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Scanner;

public class Map extends JPanel {
    private final int HVA = 1;
    private final int HVH = 2;
    private int winLength;
    private int sizeMapX;
    private int sizeMapY;
    private int locX;
    private int locY;
    private int widthCell ;
    private int heightCell ;
    private Color colorH = new Color(100,150,60);
    private Color colorAI = new Color(100,10,100);

    private boolean isGameOver = false;

    private final String STATE_WIN_HUMAN = "Human Win!!!";
    private final String STATE_WIN_AI = "Computer Win!!!";
    private final String STATE_DRAW = "Draw!!!";

    public final char DOT_HUMAN = 'X';
    public final char DOT_AI = 'O';
    public final char DOT_EMPTY = '_';

    public char[][] field ;

    public final Scanner scanner = new Scanner(System.in);
    public final Random random = new Random();

    private final AI computer = new AI(this, DOT_AI, DOT_HUMAN, DOT_EMPTY, field);

    public Map() {
        setVisible(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                updateGame(e);
            }
        });
    }

    private void updateGame(MouseEvent e){
        if(isGameOver) return;
        if(e.getX() != 0 && e.getY() != 0) {
            locX = e.getX() / widthCell;
            locY = e.getY() / heightCell;
        }
        if(!isEmptyDot(locX,locY) || !isValidDot(locX,locY)) return;
        field[locX][locY] = DOT_HUMAN;
        if(checkWin(DOT_HUMAN)){
            isGameOver = true;
            addStateWin(STATE_WIN_HUMAN);
            return;
        }
        if(isFullMap()) {
            isGameOver = true;
            addStateWin(STATE_DRAW);
            return;
        }

        computer.turn();
        if(isFullMap()) {
            isGameOver = true;
            addStateWin(STATE_DRAW);
            return;
        }
        if(checkWin(DOT_AI)){
            isGameOver = true;
            addStateWin(STATE_WIN_AI);
            return;
        }
    }

    private void addStateWin(String state){
        JPanel panelWin = new JPanel();
        int width = getWidth();
        int height = getHeight() / 6;
        int locX = getX();
        int locY = getY() + ((getHeight() - height) / 2);
        panelWin.setSize(width,height);
        panelWin.setName(state);
        panelWin.setBackground(Color.darkGray);
        add(panelWin,BorderLayout.NORTH);
    }

    void startGame(int gameMod,int sizeMapX, int sizeMapY,int winLength){
        this.sizeMapX = sizeMapX;
        this.winLength = winLength;
        this.sizeMapY = sizeMapY;
        field = new char[sizeMapX][sizeMapY];
        initMap();
        setVisible(true);
    }

    void render(Graphics g) {
        drawLines(g);
//        drawDot(g);
    }

    private void drawLines(Graphics g) {
        int currentPositionX = getX();
        int currentPositionY = getY();
        widthCell = getWidth() / sizeMapX;
        heightCell = getHeight() / sizeMapY;
        g.setColor(Color.BLACK);
        for (int i = 0; i < sizeMapX + 1; i++) {
            g.drawLine(currentPositionX, getY(), currentPositionX, getY() + getHeight());
            currentPositionX += widthCell;
            g.drawLine(getX(), currentPositionY, getX() + getWidth(), currentPositionY);
            currentPositionY += heightCell;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isVisible()) {
            render(g);
            repaint();
        }
    }

    private void drawDot (Graphics g,Color color){
        g.setColor(color);
        g.fillOval(locX,locY,widthCell / 2, heightCell / 2);
    }

//    public void playGame() {
//
//        initMap();
//        while (true) {
//            turnHuman();
//            if (checkWin(DOT_HUMAN)) {
//                System.out.println("You WIN!!! Lerush one LOVE!!!");
//                break;
//            }
//            if (!isEmptyMap()) {
//                System.out.println("Draw!!!");
//                break;
//            }
//
//            computer.turn();
//            if (checkWin(DOT_AI)) {
//                System.out.println("Computer WIN!!!");
//                break;
//            }
//            if (!isEmptyMap()) {
//                System.out.println("Draw!!!");
//                break;
//            }
//        }
//    }

    private void initMap() {
        for (int i = 0; i < sizeMapX; i++) {
            for (int j = 0; j < sizeMapY; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    boolean isValidDot(int dotX, int dotY) {
        return dotX >= 0 && dotX < sizeMapX &&
                dotY >= 0 && dotY < sizeMapY;
    }

    boolean isEmptyDot(int dotX, int dotY) {
        return field[dotX][dotY] == DOT_EMPTY;
    }

    boolean isFullMap() {
        for (int i = 0; i < sizeMapX; i++) {
            for (int j = 0; j < sizeMapY; j++) {
                if (field[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    boolean checkWin(char DOT) {
        for (int j = 0; j < field.length; j++) {
            if (isWinLine(j, DOT)) return true;
            if (isWinDiagonal(j, DOT)) return true;
        }
        return false;
    }

    boolean isWinDiagonal(int j, char DOT) {
        if (isWinDiagonalUp(j, DOT)) return true;
        if (isWinDiagonalDown(j, DOT)) return true;
        return false;
    }

    boolean isWinDiagonalDown(int j, char DOT) {
        int countX = 0;
        int countY = 0;
        for (int k = 0; k < field.length; k++) {
            countX = field.length - 1 - k - j >= 0 &&
                    field[k][field.length - 1 - k - j] == DOT ? countX + 1 : 0;
            countY = (k + j) < field.length &&
                    field[k + j][field[j].length - 1 - k] == DOT ? countY + 1 : 0;
            if (countX == winLength || countY == winLength) return true;
        }
        return false;
    }

    boolean isWinDiagonalUp(int j, char DOT) {
        int countX = 0;
        int countY = 0;
        for (int k = 0; k < field.length; k++) {
            countX = (k + j) < field[j].length &&
                    field[k][k + j] == DOT ? countX + 1 : 0;
            countY = (k + j) < field.length &&
                    field[k + j][k] == DOT ? countY + 1 : 0;
            if (countX == winLength || countY == winLength) return true;
        }
        return false;
    }

    boolean isWinLine(int left, char DOT) {
        int countV = 0;
        int countH = 0;
        for (int k = 0; k < field.length; k++) {
            countH = (field[left][k] == DOT) ? countH + 1 : 0;
            countV = (field[k][left] == DOT) ? countV + 1 : 0;
            if (countH == winLength || countV == winLength) return true;
        }
        return false;
    }

    public int getSizeMapX() {
        return sizeMapX;
    }

    public int getSizeMapY() {
        return sizeMapY;
    }
}
