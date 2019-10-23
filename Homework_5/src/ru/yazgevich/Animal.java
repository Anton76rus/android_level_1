package ru.yazgevich;

public class Animal {

    private String name;
    private String color;
    private int age;
    int limitRun;
    float limitJump;
    int limitSwim;

    Animal(String name,String color,int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    Animal(String name,String color,int age,int limitRun,float limitJump,int limitSwim) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.limitJump = limitJump;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
    }

    public void fullInfo(){
        System.out.println("Name is " + name);
        System.out.println("Color is " + color);
        System.out.println(age + " age old");
        System.out.println("Limit run " + limitRun + " m");
        System.out.println("Limit jump " + limitJump + " m");
        System.out.println("Limit swim " + limitSwim + " m");
    }

    public void run (int distance){
        if (distance <= limitRun){
            System.out.println(name + " ran !!!");
        }else {
            System.out.println(name + " can`t run that far");
        }
    }
    public void swim (int distance){
        if (distance <= limitSwim) {
            System.out.println(name + " swam !!!");
        }else {
            System.out.println(name + " can`t swim that far");
        }
    }

    public void jump (int high){
        if (high <= limitJump){
            System.out.println(name + " jumped !!!");
        }else {
            System.out.println(name + " can`t jump that high");
        }
    }
}
