package ru.yazgevich.com;

import ru.yazgevich.Bird;
import ru.yazgevich.Cat;
import ru.yazgevich.Dog;
import ru.yazgevich.Horse;

public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik","White",7);
        Cat cat2 = new Cat("Murzik","Black",5,150,3,2);
        Dog dog1 = new Dog("Sharik","Ginger",13);
        Horse horse1 = new Horse("Plotva","Pied",20);
        Bird bird1 = new Bird("Chizhik","Motley",35);

        cat1.fullInfo();
        System.out.println("________________________________________\n");
        cat2.fullInfo();
        System.out.println("________________________________________\n");
        dog1.fullInfo();
        System.out.println("________________________________________\n");
        horse1.fullInfo();
        System.out.println("________________________________________\n");
        bird1.fullInfo();
        System.out.println("________________________________________\n");

        cat1.run(200);
        cat1.jump(3);
        cat1.swim(2);
        System.out.println("________________________________________\n");
        cat2.run(200);
        cat2.jump(3);
        cat2.swim(2);
        System.out.println("________________________________________\n");
        dog1.run(500);
        dog1.jump(3);
        dog1.swim(2);
        System.out.println("________________________________________\n");
        horse1.run(1000);
        horse1.jump(3);
        horse1.swim(2);

    }
}
