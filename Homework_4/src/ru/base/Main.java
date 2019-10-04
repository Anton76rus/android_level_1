package ru.base;

public class Main {

    public static void main(String[] args) {
        Employee[] arrWorkers = new Employee[]{
                new Employee("Yazgevich Anton", "JAVA Developer", "+79806569561", 35000, 30),
                new Employee("Ivan Grozny", "King", "absent", 0, 53),
                new Employee("Putin Vladimir", "King", "classified", 100500, 99),
                new Employee("Justin Bieber", "Singer", "4582528", 500000, 15),
                new Employee("Sokolova Polina", "Artist", "+79864548657", 5000, 26),
        };

        searchWorkers(arrWorkers, 40);
        changePension(arrWorkers, 45);
    }

    private static void searchWorkers(Employee[] arr, int limitAge) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAge() >= limitAge) {
                arr[i].fullInfo();
            }
        }
    }

    private static void changePension(Employee[] arr, int limitAge) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAge() >= limitAge) {
                System.out.println("\nName is " + arr[i].getFull_name() +
                        "\nSalary before " + arr[i].getSalary());
                arr[i].setSalary(arr[i].getSalary() + 5000);
                System.out.println("Salary after " + arr[i].getSalary());
                System.out.println("__________________________________");
            }
        }
    }


}
