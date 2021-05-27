package ru.geekbrains.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Map extends JPanel {
    private final int HVA = 1;
    private final int HVH = 2;
    private int winLength;
    private int sizeMapX;
    private int sizeMapY;

    public final char HUMAN_DOT = 'X';
    public final char AI_DOT = 'O';
    public final char EMPTY_DOT = '_';

    public char[][] field = new char[sizeMapX][sizeMapY];

    public final Scanner scanner = new Scanner(System.in);
    public final Random random = new Random();

    private final AI computer = new AI(this, AI_DOT, HUMAN_DOT, EMPTY_DOT, field);

    public Map() {
        setVisible(false);
    }

    public void startGameMap(int gameMode, int sizeMapX, int sizeMapY, int winLength) {
        this.sizeMapX = sizeMapX;
        this.winLength = winLength;
        this.sizeMapY = sizeMapY;
        setVisible(true);
    }

    void render(Graphics g) {
        drawLines(g);
    }

    private void drawLines(Graphics g) {
        int currentPositionX = getX();
        int currentPositionY = getY();
        int widthCell = getWidth() / sizeMapX;
        int heightCell = getHeight() / sizeMapY;
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
        }
    }

    public void main(String[] args) {

        initMap();
        printMap();
        while (true) {
            turnHuman();
            printMap();
            if (checkWin(HUMAN_DOT)) {
                System.out.println("You WIN!!! Lerush one LOVE!!!");
                break;
            }
            if (!isEmptyMap()) {
                System.out.println("Draw!!!");
                break;
            }

            computer.turn();
            printMap();
            if (checkWin(AI_DOT)) {
                System.out.println("Computer WIN!!!");
                break;
            }
            if (!isEmptyMap()) {
                System.out.println("Draw!!!");
                break;
            }
        }
    }

    private void initMap() {
        for (int i = 0; i < sizeMapX; i++) {
            for (int j = 0; j < sizeMapY; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private void printMap() {
        System.out.print("|");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[j][i] + "|");
            }
            if (i < field.length - 1) System.out.print("\n|");
        }
        System.out.println("\n");
    }

    boolean isValidDot(int dotX, int dotY) {
        return dotX >= 0 && dotX < sizeMapX &&
                dotY >= 0 && dotY < sizeMapY;
    }

    boolean isEmptyDot(int dotX, int dotY) {
        return field[dotX][dotY] == EMPTY_DOT;
    }

    private void turnHuman() {
        int dotX;
        int dotY;
        do {
            System.out.println("Enter two numbers x and y." +
                    "\n Numbers must be between 1 and " + sizeMapX + " for X " +
                    "\nand between 1 and " + sizeMapY + " for Y.");
            dotX = scanner.nextInt() - 1;
            dotY = scanner.nextInt() - 1;
        } while (!isValidDot(dotX, dotY) && !isEmptyDot(dotX, dotY));
        field[dotX][dotY] = HUMAN_DOT;
    }

    boolean isEmptyMap() {
        for (int i = 0; i < sizeMapX; i++) {
            for (int j = 0; j < sizeMapY; j++) {
                if (field[i][j] == EMPTY_DOT) return true;
            }
        }
        return false;
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
