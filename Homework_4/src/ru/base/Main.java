package ru.base;

public class Main {

    public static void main(String[] args) {
        Employee worker1 = new Employee("Yazgevich Anton","JAVA Developer","+79806569561",35000,30);
        Employee worker2 = new Employee("Ivan Grozny","King","absent",0,53);
        Employee worker3 = new Employee("Putin Vladimir","King","classified",100500,99);
        Employee worker4 = new Employee("Justin Bieber","Singer","4582528",500000,15);
        Employee worker5 = new Employee("Sokolova Polina","Artist","+79864548657",5000,26);
        Employee[] arrWorkers = new Employee[]{worker1,worker2,worker3,worker4,worker5};

        System.out.println("Full name = " + worker1.getFull_name());
        System.out.println("Position = " + worker1.getPosition());
        getDateOfWorkers(arrWorkers,40);
        toIncreasePension(arrWorkers,45);
    }

    public static void getDateOfWorkers(Employee[] arr,int limit){
        for (int i = 0;i < arr.length;i++){
            if(arr[i].getAge() >= limit) {
                System.out.println("\nFull name - " + arr[i].getFull_name());
                System.out.println("Position - " + arr[i].getPosition());
                System.out.println("Phone number - " + arr[i].getPhone_number());
                System.out.println("Salary - " + arr[i].getSalary());
                System.out.println("Age - " + arr[i].getAge());
                System.out.println("Serial number - " + arr[i].getSerialNumber());
            }
        }
    }

    public static void toIncreasePension(Employee[] arr,int limit){
        for (int i = 0;i < arr.length;i++) {
            if (arr[i].getAge() >= limit){
                System.out.println("\nSalary before " + arr[i].getSalary());
                arr[i].setSalary(arr[i].getSalary() + 5000);
                System.out.println("Salary after " + arr[i].getSalary());
            }
        }
    }


}
