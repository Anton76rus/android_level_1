package ru.geekbrains.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static final char HUMAN_DOT = 'X';
    public static final char AI_DOT = 'O';
    public static final char EMPTY_DOT = '_';

    public static final int WIN_VALUE = 4;

    public static final int sizeX = 5;
    public static final int sizeY = 5;
    public static char[][] map = new char[sizeX][sizeY];

    public static final Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random();

    private static AI computer = new AI(AI_DOT,HUMAN_DOT,EMPTY_DOT,map);

    public static void main(String[] args) {

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

    private static void initMap() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                map[i][j] = EMPTY_DOT;
            }
        }
    }

    private static void printMap() {
        System.out.print("|");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[j][i] + "|");
            }
            if (i < map.length - 1) System.out.print("\n|");
        }
        System.out.println("\n");
    }

    static boolean isValidDot(int dotX, int dotY) {
        return dotX >= 0 && dotX < sizeX &&
                dotY >= 0 && dotY < sizeY;
    }

    static boolean isEmptyDot(int dotX, int dotY) {
        return map[dotX][dotY] == EMPTY_DOT;
    }

    private static void turnHuman() {
        int dotX;
        int dotY;
        do {
            System.out.println("Enter two numbers x and y." +
                    "\n Numbers must be between 1 and " + sizeX + " for X " +
                    "\nand between 1 and " + sizeY + " for Y.");
            dotX = scanner.nextInt() - 1;
            dotY = scanner.nextInt() - 1;
        } while (!isValidDot(dotX, dotY) && !isEmptyDot(dotX, dotY));
        map[dotX][dotY] = HUMAN_DOT;
    }

    static boolean isEmptyMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == EMPTY_DOT) return true;
            }
        }
        return false;
    }

    static boolean checkWin(char DOT) {
        for (int j = 0; j < map.length; j++) {
            if (isWinLine(j, DOT)) return true;
            if (isWinDiagonal(j, DOT)) return true;
        }
        return false;
    }

    static boolean isWinDiagonal(int j, char DOT) {
        if (isWinDiagonalUp(j, DOT)) return true;
        if (isWinDiagonalDown(j, DOT)) return true;
        return false;
    }

    static boolean isWinDiagonalDown(int j, char DOT) {
        int countX = 0;
        int countY = 0;
        for (int k = 0; k < map.length; k++) {
            countX = map.length - 1 - k - j >= 0 &&
                    map[k][map.length - 1 - k - j] == DOT ? countX + 1 : 0;
            countY = (k + j) < map.length &&
                    map[k + j][map[j].length - 1 - k] == DOT ? countY + 1 : 0;
            if (countX == WIN_VALUE || countY == WIN_VALUE) return true;
        }
        return false;
    }

    static boolean isWinDiagonalUp(int j, char DOT) {
        int countX = 0;
        int countY = 0;
        for (int k = 0; k < map.length; k++) {
            countX = (k + j) < map[j].length &&
                    map[k][k + j] == DOT ? countX + 1 : 0;
            countY = (k + j) < map.length &&
                    map[k + j][k] == DOT ? countY + 1 : 0;
            if (countX == WIN_VALUE || countY == WIN_VALUE) return true;
        }
        return false;
    }

    static boolean isWinLine(int left, char DOT) {
        int countV = 0;
        int countH = 0;
        for (int k = 0; k < map.length; k++) {
            countH = (map[left][k] == DOT) ? countH + 1 : 0;
            countV = (map[k][left] == DOT) ? countV + 1 : 0;
            if (countH == WIN_VALUE || countV == WIN_VALUE) return true;
        }
        return false;
    }

}