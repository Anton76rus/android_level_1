package ru.yazgevich;

public class Cat extends Animal {

    public Cat(String name, String color, int age) {
        super(name, color, age);
        super.limitRun = 200;
        super.limitSwim = 0;
        super.limitJump = 2;
    }

    public Cat(String name, String color, int age, int limitRun, float limitJump, int limitSwim) {
        super(name, color, age, limitRun, limitJump, limitSwim);
    }
    @Override
    public void swim(int distance){
       if (limitSwim <= 0) {
           System.out.println("The cat are not able swim");
       }else {
           System.out.println("The cat swam !!!");
       }
    }
}
