package ru.yazgevich;

public class HomeworkOne {

    public static void main(String[] args) {
        int a = 5;
        int b = 16;
        int c = 4;
        int d = 3;
        int year = 2020;
        String name = "Антон";
        System.out.println(getSum(a, b, c, d));
        System.out.println(fallWithin(a, b));
        getPositive(a);
        System.out.println(getHello(name));
        findLeapYear(year);
    }

    private static float getSum(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    private static boolean fallWithin(int a, int b) {
        if (a + b <= 20 && a + b >= 10) return true;
        else return false;
    }

    private static void getPositive(int a) {
        if (a < 0) {
            System.out.println("Число " + a + " отрицательное");
        } else {
            System.out.println("Число " + a + " положительное");
        }
    }

    private static String getHello(String name) {
        return "Привет, " + name + "!";
    }

    private static void findLeapYear(int year) {
        if (year % 4 == 0 & (year % 100 != 0 || year % 400 == 0)) {
            System.out.println(year + " является високосным");
        } else System.out.println(year + " не является високосным");
    }
}
