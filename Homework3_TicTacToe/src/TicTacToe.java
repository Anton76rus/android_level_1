import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '_';

    private static Scanner SCANNER = new Scanner(System.in);
    private static Random RANDOM = new Random();

    private static final int WIN = 4;
    private static final int fieldSizeX = 5;
    private static final int fieldSizeY = 5;
    private static char[][] field = new char[fieldSizeY][fieldSizeX];

    private static boolean isValidCell(int x,int y) {
        return x < 0 || x >= fieldSizeX || y < 0 || y >= fieldSizeY;
    }
    private static boolean isEmptyDot(int x,int y){
        return field[x][y] == DOT_EMPTY;
    }

    private static boolean isHumanDot(int x,int y){
        return field[x][y] == DOT_X;
    }

    private static void initMap(){
        for (int y = 0;y < fieldSizeY;y++){
            for (int x = 0; x < fieldSizeX;x++){
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printMap(){
        System.out.print("   ");
        for(int i = 1;i <= field.length;i++){
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int y = 0;y < field.length;y++){
            System.out.print(y + 1 + " ");
            for(int x = 0;x < field.length;x++){
                System.out.print("|" + field[x][y] + "|");
            }
            System.out.println(" ");
        }
        System.out.println();
    }

    private static void humanTurn(){
        int x;
        int y;
        System.out.println("Ваш ход!");
        do {
            System.out.println("Введите координаты хода Х и Y (от 1 до " + field.length + ") через пробел  или ENTER");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        }while (isValidCell(x,y) || !isEmptyDot(x,y));
        field[x][y] = DOT_X;
    }

    private static void aITurn(){
        System.out.println("Ход компьютера!");
        int bias = field.length - WIN;
        int lineX = 0;
        int lineY = 0;
        int diaDownX = 0;
        int diaUpX = 0;
        int diaDownY = 0;
        int diaUpY = 0;
        boolean ddX,duX,ddY,duY,lx,ly;
        char[][] copyField;
        copyField = field.clone();

        for (int x = 0;x < fieldSizeX;x++){
            for (int y = 0;y < fieldSizeY;y++){
                lx = field[x][y] == DOT_X && y > 0 && field[x][y - 1] == DOT_X;
                ly = field[y][x] == DOT_X && y > 0 && field[y - 1][x] == DOT_X;
                /**Линия Х */
                if (lx) lineX++;
                if (lineX >= WIN - 2) {
                    if (y + 1 < field.length) {
                        field[x][y + 1] = DOT_O;
                        if(Arrays.equals(copyField,field)) return;
                    }
                    field[x][y - WIN + 1] = DOT_O;
                    if(Arrays.equals(copyField,field)) return;
                }
                /** Линия Y */
                if (ly) lineY++;
                if (lineY >= WIN - 2){
                    if(y + 1 < field.length){
                        field[y + 1][x] = DOT_O;
                        if (Arrays.equals(copyField,field)) return;
                    }
                    field[y - WIN + 1][x] = DOT_O;
                    if(Arrays.equals(copyField,field)) return;
                }
            }
        }
        for (int i = 0;i <= bias;i++) {
            for (int x = 0; x < fieldSizeX; x++) {
                ddX = x - 1 >= 0 && field[x - 1][x - 1 + i] == DOT_X;
                ddY = x - 1 >= 0 && field[x - 1 + i][x - 1] == DOT_X;
                duY = x - 1 >= 0 && field.length - x - i < field.length && field[x - 1][field.length - x - i] == DOT_X;
                duX = x - 1 + i >= 0 && field.length - x < field.length && field[x - 1 + i][field.length - x] == DOT_X;
                if (x + i < field.length) {
                    /** Диагональ со смещением Y */
                    if (field[x][x + i] == DOT_X && ddX) diaDownX++;
                    if (diaDownX >= WIN - 2){
                        if(x + i + 1 < field.length) {
                            field[x + 1][x + i + 1] = DOT_O;
                            if (Arrays.equals(copyField, field)) return;
                        }
                        field[x - WIN + 1][x + i - WIN + 1] = DOT_O;
                        if(Arrays.equals(copyField,field)) return;
                    }
                    /** Диагональ со смещением Х */
                    if (field[x + i][x] == DOT_X && ddY) diaDownY++;
                    if (diaDownY >= WIN - 2){
                        if(x + i + 1 < field.length) {
                            field[x + i + 1][x + 1] = DOT_O;
                            if (Arrays.equals(copyField, field)) return;
                        }
                        field[x + i - WIN + 1][x - WIN + 1] = DOT_O;
                        if(Arrays.equals(copyField,field)) return;
                    }
                    /** Обратная диагональ со смещением Х */
                    if (field[x + i][field.length - 1 - x] == DOT_X && duX) diaUpX++;
                    if (diaUpX >= WIN - 2){
                        if(x + i + 1 < field.length && field.length - 2 - x >= 0) {
                            field[x + i + 1][field.length - 2 - x] = DOT_O;
                            if (Arrays.equals(copyField, field)) return;
                        }
                        field[x + i - WIN + 1][field.length - 2 - x + WIN] = DOT_O;
                        if(Arrays.equals(copyField,field)) return;
                    }
                }
                /** Обратная диагональ со смещением Y */
                if (field.length - 1 - x - i >= 0) {
                    if (field[x][field.length - 1 - x - i] == DOT_X && duY) diaUpY++;
                    if (diaUpY >= WIN - 2){
                        if(x + 1 < field.length && field.length - 2 - x - i >= 0) {
                            field[x + 1][field.length - 2 - x - i] = DOT_O;
                            if (Arrays.equals(copyField, field)) return;
                        }
                        field[x - WIN + 1 ][field.length - 2 - x + WIN - i] = DOT_O;
                        if(Arrays.equals(copyField,field)) return;
                    }
                }
            }
        }
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        }while (isEmptyDot(x,y) && isHumanDot(x,y));
        field[x][y] = DOT_O;
    }

    private static boolean checkWin(int dot){
        int bias = field.length - WIN;
        int lineX = 0;
        int lineY = 0;
        int diaDownX = 0;
        int diaUpX = 0;
        int diaDownY = 0;
        int diaUpY = 0;
        boolean ddX,duX,ddY,duY,lx,ly;

        for (int x = 0;x < fieldSizeX;x++){
            for (int y = 0;y < fieldSizeY;y++){
                lx = y > 0 && field[x][y - 1] == dot;
                ly = y > 0 && field[y - 1][x] == dot;
                if (field[x][y] == dot && (lineX == 0 || lx)) lineX++;
                if (field[y][x] == dot && (lineY == 0 || ly)) lineY++;
            }
            lineX = 0;
            lineY = 0;
            if(lineX >= WIN || lineY >= WIN) return true;
        }
        for (int i = 0;i <= bias;i++) {
            for (int x = 0; x < fieldSizeX; x++) {
                ddX = x - 1 >= 0 && field[x - 1][x - 1 + i] == dot;
                ddY = x - 1 >= 0 && field[x - 1 + i][x - 1] == dot;
                duX = (x - 1 >= 0 && field.length - 2 - x >= 0 && field.length - x + i < 5) && field[x - 1][field.length - x + i] == dot;
                duY = (x - 1 >= 0 && field.length - 2 - x >= 0) && field[x - 1 + i][field.length - x] == dot;
                if (x + i < field.length) {
                    if (field[x][x + i] == dot && (diaDownX == 0 || ddX)) diaDownX++;
                    if (field[x + i][x] == dot && (diaDownY == 0 || ddY)) diaDownY++;
                    if (field[x + i][field.length - 1 - x] == dot && (diaUpY == 0 || duY)) diaUpX++;
                }
                if (field.length - 1 - x - i >= 0) {
                    if (field[x][field.length - 1 - x - i] == dot && (diaUpX == 0 || duX)) diaUpY++;
                }
                if (diaDownX >= WIN || diaUpX >= WIN || diaDownY >= WIN || diaUpY >= WIN) return true;
            }
            diaDownX = 0;
            diaDownY = 0;
            diaUpX = 0;
            diaUpY = 0;
        }
        return false;
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
