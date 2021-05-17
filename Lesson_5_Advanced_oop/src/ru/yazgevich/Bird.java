package ru.yazgevich;

public class Bird extends Animal {
    public Bird(String name, String color, int age) {
        super(name, color, age);
        super.limitRun = 5;
        super.limitSwim = 0;
        super.limitJump = 0.2f;
    }

    public Bird(String name, String color, int age, int limitRun, float limitJump, int limitSwim) {
        super(name, color, age, limitRun, limitJump, limitSwim);
    }

    @Override
    public void swim(int distance){
        if (limitSwim <= 0) {
            System.out.println("The Bird are not able swim");
        }else {
            System.out.println("The Bird swam !!!");
        }
    }
}
