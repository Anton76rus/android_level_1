package ru.yazgevich;

public class HomeworkOne {

    public static void main(String[] args){
        int a = 5;
        int b = 16;
        int c = 4;
        int d = 3;
        System.out.println(getSum(a,b,c,d));
        System.out.println(fallWithin(a,b));
        getPositiv(a);
    }

    private static float getSum(float a,float b,float c,float d){
        return  a*(b+(c/d));
    }

    private static boolean fallWithin(int a, int b){
        if(a + b <= 20 && a + b >= 10) return true;
        else return false;
    }

    private static void getPositiv (int a){
        if(a < 0) {
            System.out.println("Число " + a + " отрицательное");
        } else {
            System.out.println("Число " + a + " положительное");
        }
    }
}
