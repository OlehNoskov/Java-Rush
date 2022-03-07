package ua.com.javarush.multithreading.big_task_refactoring.human;

public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {
            fight();
    }

    public void fight() {
    }
}
