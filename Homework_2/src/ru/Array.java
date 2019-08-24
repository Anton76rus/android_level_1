package ru;

import java.util.Arrays;

public class Array {

    /**
     * Создано 24.08.2019
     * Домашняя работа к уроку №2
     * Курс Java.уровень 1
     * Автор Антон Язгевич
     */

    private static void reverseArray(int[] arrZero){
        for (int i = 0;i < arrZero.length;i++){
            arrZero[i] = arrZero[i] == 0 ? 1 : 0;
        }
    }

    private static void fillArray (int[] arrEmpty){
        for (int i = 0;i < arrEmpty.length;i++){
            if (i != 0){
                arrEmpty[i] = arrEmpty[i - 1] + 3;
            }else {
                arrEmpty[i] = 1;
            }
        }
    }

    private static void multiplyArray(int[] arrDone){
        for(int i = 0;i < arrDone.length;i++){
            if(arrDone[i] < 6){
                arrDone[i] *= 2;
            }
        }
    }

    private static int findMinValue(int[]arrMin){
        int min = arrMin[0];
        for (int i = 0;i < arrMin.length;i++){
            if(arrMin[i] <= min){
                min = arrMin[i];
            }
        }
        return min;
    }

    private static int findMaxValue(int[]arrMin){
        int max = arrMin[0];
        for (int i = 0;i < arrMin.length;i++){
            if(arrMin[i] >= max){
                max = arrMin[i];
            }
        }
        return max;
    }

    private static void fillDiagonalArray(int[][] arrX){
        for (int x = 0;x < arrX.length;x++){
            for (int y = 0;y < arrX.length;y++){
                if (x == y) arrX[x][y] = 1;
            }
        }
        int x = 0;
        int y = arrX.length - 1;
        while(x < arrX.length){
            arrX[x][y] = 1;
            x++;
            y--;
        }
    }

    private static void printArray(int[][] arrAny){
        for (int x = 0;x < arrAny.length;x++){
            for (int y = 0;y < arrAny.length;y++){
                System.out.print(arrAny[x][y] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        int[] arr01 = {1,1,0,0,1,0,1,1,0};
        int[] arrEmpty = new int[8];
        int[] arrDone = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] arrMM = {3,6,8,14,2,6,22,7,35,4};
        int[][] arrX = new int[5][5];

        reverseArray(arr01);
        System.out.println(Arrays.toString(arr01));
        fillArray(arrEmpty);
        System.out.println(Arrays.toString(arrEmpty));
        multiplyArray(arrDone);
        System.out.println(Arrays.toString(arrDone));
        System.out.println(findMinValue(arrMM) + " is minimum array value");
        System.out.println(findMaxValue(arrMM) + " is maximum array value");
        fillDiagonalArray(arrX);
        printArray(arrX);
    }
}
