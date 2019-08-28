import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '_';

    private static Scanner SCANNER = new Scanner(System.in);
    private static Random RANDOM = new Random();

    private static final int WIN = 3;
    private static final int fieldSizeX = 3;
    private static final int fieldSizeY = 3;
    private static char[][] field = new char[fieldSizeY][fieldSizeX];

    private static boolean isValidCell(int x,int y){
        return x > 0 && x <= fieldSizeX && y > 0 && y <= fieldSizeY;
    }

    private static boolean isEmptyDot(int x,int y){
        return field[x][y] == DOT_EMPTY;
    }

    private static boolean isHumanDot(int x,int y){
        return field[x][y] == DOT_X;
    }

    private static boolean isAIDot(int x,int y){
        return field[x][y] == DOT_O;
    }

    private static void initMap(){
        for (int y = 0;y < fieldSizeY;y++){
            for (int x = 0; x < fieldSizeX;x++){
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printMap(){
        System.out.println("   1  2  3");
        for (int y = 0;y < field.length;y++){
            System.out.print(y + 1 + " ");
            for(int x = 0;x < field.length;x++){
                System.out.print("|" + field[x][y] + "|");
            }
            System.out.println(" ");
        }
    }

    private static void humanTurn(){
        int x;
        int y;
        System.out.println("\nВаш ход!!!");
        do {
            System.out.println("Введите координаты хода Х и Y (от 1 до " + field.length + ") через пробел");
            y = SCANNER.nextInt() - 1;
            x = SCANNER.nextInt() - 1;
        }while (!isValidCell(x,y) && !isEmptyDot(y,x) && isAIDot(y,x));
        field[x][y] = DOT_X;
    }

    private static void aITurn(){
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        }while (!isEmptyDot(x,y) && isHumanDot(x,y));
        field[x][y] = DOT_O;
    }

    private static boolean checkWin(int dot){
        int count = 0;
        for (int x = 0;x < fieldSizeX;x++){
            for (int y = 0;y < fieldSizeY;y++){
                if (field[x][y] == dot) count++;
            }
        }
        return count >= WIN ? true : false;
    }

    private static boolean checkDraw(){
        for (int y = 0;y < fieldSizeY;y++){
            for (int x = 0; x < fieldSizeX;x++){
                if(field[y][x] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Winner winner chicken dinner!!!");
                break;
            }
            if (checkDraw()){
                System.out.println("Опачки!Ничья!");
                break;
            }
            aITurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил кампуктер !!! Лол");
                break;
            }
            if (checkDraw()){
                System.out.println("Опачки!Ничья!");
                break;
            }
        }
    }
}
