package ua.com.javarush.multithreading.big_task_refactoring.human;

public class Worker extends Human {

    private double salary;
    public String company;

    public Worker(String name, int age) {
        super(name, age);
    }

    public double getSalary() {
        return salary;
    }

    public void setSlr(double salary) {
        this.salary = salary;
    }
}