package ua.com.javarush.multithreading.big_task_refactoring.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {

    public class Size {

        private int height;
        private int weight;
    }

    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

    private List<Human> children = new ArrayList<>();

    protected Size size;
    private BloodGroup bloodGroup;

    public void setBloodGroup(BloodGroup code) {
        bloodGroup = code;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public void live() {
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void removeChild(Human child) {
        children.remove(child);
    }

    public String getPosition() {
        return "Human";
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}