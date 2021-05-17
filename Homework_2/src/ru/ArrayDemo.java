package ru;

import java.util.Arrays;

    /**
     * Created 24.08.2019
     * Homework for lesson 2
     * Course Java.level 1
     * Author Anton Yazgevich
     * Last update 20.04.2021
     */

    public class ArrayDemo {

        public static void main(String[] args) {
            int[] bitArray = {1, 0, 0, 1, 1, 0, 0, 1};
            int[] emptyArr = new int[8];
            int[] someArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            int[][] emptyTwoDimeArr = new int[5][5];
            int[] twoHalfArr = {2, 5, 0, 0, 7};
            System.out.println("After revers : " + Arrays.toString(bitArray));
            reverseArr(bitArray);
            System.out.println("Before revers : " + Arrays.toString(bitArray));

            mathProgressionArr(emptyArr);
            System.out.println(Arrays.toString(emptyArr));

            buffValueArr(someArr);
            System.out.println(Arrays.toString(someArr) + "\n");

            System.out.println("Minimum array value - " + findMinValueArr(someArr));
            System.out.println("Maximum array value - " + findMaxValueArr(someArr) + "\n");

            fillDiagArr(emptyTwoDimeArr);
            printTwoDimensionalArray(emptyTwoDimeArr);

            System.out.println(areArrHalvesEquals(twoHalfArr));

            offsetArrayValues(twoHalfArr, -1);
            System.out.println(Arrays.toString(twoHalfArr));
        }

        private static void reverseArr(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] == 0 ? 1 : 0;
            }
        }

        private static void mathProgressionArr(int[] arr) {
            for (int i = 0, k = 1; i < arr.length; i++, k += 3) {
                arr[i] = k;
            }
        }

        private static void buffValueArr(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 6) arr[i] *= 2;
            }
        }

        private static int findMaxValueArr(int[] arr) {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) max = arr[i];
            }
            return max;
        }

        private static int findMinValueArr(int[] arr) {
            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) min = arr[i];
            }
            return min;
        }

        private static void fillDiagArr(int[][] arr) {
            for (int i = 0; i < arr.length; i++) {
                arr[i][i] = 1;
                arr[i][arr.length - 1 - i] = 1;
            }
        }

        private static void printTwoDimensionalArray(int[][] arr) {
            for (int i = 0; i < arr.length; i++) {
                for (int k = 0; k < arr.length; k++) {
                    System.out.print(arr[k][i] + " ");
                }
                System.out.println();
            }
        }

        private static boolean areArrHalvesEquals(int[] arr) {
            int sum = 0;
            int left = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            for (int i = 0; i < arr.length; i++) {
                if (sum > left) {
                    left += arr[i];
                    sum -= arr[i];
                }
                if (sum == left) return true;
            }
            return false;
        }

        private static void offsetArrayValues(int[] arr, int offset) {
            int lostValue;

            // offset is positive
            if (offset < 0) {
                for (int i = 0; i > offset; i--) {
                    lostValue = arr[0];
                    for (int j = 0; j < arr.length - 1; j++) {
                        arr[j] = arr[j + 1];
                    }
                    arr[arr.length - 1] = lostValue;
                }
            }

            // offset is negative
            if (offset > 0) {
                for (int i = 0; i < offset; i++) {
                    lostValue = arr[arr.length - 1];
                    for (int j = 0; j < arr.length - 1; j++) {
                        arr[arr.length - 1 - j] = arr[arr.length - 2 - j];
                    }
                    arr[0] = lostValue;
                }
            }
        }
    }
