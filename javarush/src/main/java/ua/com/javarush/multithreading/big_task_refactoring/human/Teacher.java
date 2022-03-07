package ua.com.javarush.multithreading.big_task_refactoring.human;

public class Teacher extends Human {

    private int numberOfStudents;

    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);
        this.numberOfStudents = numberOfStudents;
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

    @Override
    public String getPosition(){
        return "Teacher";
    }
}