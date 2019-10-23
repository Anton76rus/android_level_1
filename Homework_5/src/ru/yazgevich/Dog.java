package ru.yazgevich;

public class Dog extends Animal {
    public Dog(String name, String color, int age) {
        super(name, color, age);
        super.limitRun = 500;
        super.limitSwim = 10;
        super.limitJump = 0.5f;
    }

    public Dog(String name, String color, int age, int limitRun, float limitJump, int limitSwim) {
        super(name, color, age, limitRun, limitJump, limitSwim);
    }
}
