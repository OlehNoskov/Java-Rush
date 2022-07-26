package ua.com.javarush.annotations.my_annotation;

public class Solution {
    public static void main(String[] args) {
        System.out.println(fight(EvilMaster.class, Elf.class));
        Object object = new Object();
    }

    public static boolean fight(Class first, Class second){

        // Проверяет, если ли у класса нужная аннотация
        if(!first.isAnnotationPresent(Person.class)){
            throw new RuntimeException("first param not game person");
        }
        // Проверяет, если ли у класса нужная аннотация
        if(!second.isAnnotationPresent(Person.class)){
            throw new RuntimeException("second param not game person");
        }

        // Возвращает обьект аннотацию, если такая у класса есть
        Person firstPerson = (Person) first.getAnnotation(Person.class);
        // Возвращает обьект аннотацию, если такая у класса есть
        Person secondPerson = (Person) second.getAnnotation(Person.class);

        int firstAttack = firstPerson.attack() * firstPerson.strength() + firstPerson.magic();
        int firstPower = firstPerson.live() * firstPerson.defence() * firstAttack;

        int secondAttack = secondPerson.attack() * secondPerson.strength() + secondPerson.magic();
        int secondPower = secondPerson.live() * secondPerson.defence() * secondAttack;

        return firstPower > secondPower;
    }
}