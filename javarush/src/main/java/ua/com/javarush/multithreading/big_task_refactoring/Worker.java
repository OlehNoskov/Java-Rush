package ua.com.javarush.multithreading.big_task_refactoring;

public class Worker {
    private Human human;
    private double salary;
    public String company;

    public Worker(String name, int age) {
        human = new Human(false);
    }

    public void live() {
        human.live();
    }

    public double getSalary() {
        return salary;
    }

    public void setSlr(double salary) {
        this.salary = salary;
    }
}