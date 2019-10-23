package ru.yazgevich;

public class Horse extends Animal {
    public Horse(String name, String color, int age) {
        super(name, color, age);
        super.limitRun = 1500;
        super.limitSwim = 100;
        super.limitJump = 3f;
    }

    public Horse(String name, String color, int age, int limitRun, float limitJump, int limitSwim) {
        super(name, color, age, limitRun, limitJump, limitSwim);
    }
}
