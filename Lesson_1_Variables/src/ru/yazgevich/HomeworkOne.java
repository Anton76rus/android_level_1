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

        if (getPositive(a)) System.out.println("The number is positive");
        else System.out.println("The number is negative");

        System.out.println(getHello(name));

        if (findLeapYear(year)) System.out.println(year + " is leap year");
        else System.out.println(year + " is not leap year");
    }

    private static float getSum(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    private static boolean fallWithin(int a, int b) {
        return a + b <= 20 && a + b >= 10;
    }

    private static boolean getPositive(int a) {
        return a >= 0;
    }

    private static String getHello(String name) {
        return "Привет, " + name + "!";
    }

    private static boolean findLeapYear(int year) {
        return (year % 4 == 0 & (year % 100 != 0 || year % 400 == 0));
    }
}
