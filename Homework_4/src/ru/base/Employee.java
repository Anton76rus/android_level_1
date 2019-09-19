package ru.base;

public class Employee {
    private String full_name;
    private String position;
    private String phone_number;
    private int salary;
    private int age;
    private int serial_number = 0;

    Employee(String full_name, String position, String phone_number, int salary, int age){
        this.full_name = full_name;
        this.position = position;
        this.phone_number = phone_number;
        this.salary = salary;
        this.age = age;
        serial_number += 1;
    }

    String getFull_name(){
        return full_name;
    }

    String getPosition(){
        return position;
    }

    String getPhone_number(){
        return phone_number;
    }

    int getSalary(){
        return salary;
    }

    int getAge(){
        return age;
    }

    public int getSerialNumber() {
        return serial_number;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
