package ru.base;

class Employee {
    private String full_name;
    private String position;
    private String phoneNumber;
    private int salary;
    private int age;
    private static int serialNumber = 0;
    private int id;

    Employee(String full_name, String position, String phone_number, int salary, int age){
        this.full_name = full_name;
        this.position = position;
        this.phoneNumber = phone_number;
        this.salary = salary;
        this.age = age;
        this.id = ++serialNumber;
    }

    String getFull_name(){
        return full_name;
    }

    String getPosition(){
        return position;
    }

    String getPhone_number(){
        return phoneNumber;
    }

    int getSalary(){
        return salary;
    }

    int getAge(){
        return age;
    }

    void setSalary(int salary) {
        this.salary = salary;
    }

    int getId() {
        return id;
    }

    void fullInfo(){
        System.out.println("\nFull name - " + getFull_name() +
                "\nPosition - " + getPosition() +
                "\nPhone number - " + getPhone_number() +
                "\nSalary - " + getSalary() +
                "\nAge - " + getAge() +
                "\nSerial number - " + getId());
        System.out.println("__________________________________");
    }
}
