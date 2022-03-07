package ua.com.javarush.multithreading.big_task_refactoring;

public class Professor extends Teacher {

    public Professor(String name, int age, int numberOfStudents) {
        super(name, age, numberOfStudents);
    }

    public void live() {
        teach();
    }
}