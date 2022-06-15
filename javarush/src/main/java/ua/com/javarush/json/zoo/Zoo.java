package ua.com.javarush.json.zoo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public List<Animal> animals = new ArrayList<>();

    //Используется для указания деталей информации о типе, которая должна быть включена в сериализацию и десериализацию
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
    //Используется для обозначения подтипов аннотированных типов
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Dog.class, name = "dog"),
            @JsonSubTypes.Type(value = Cat.class, name = "cat")
    })
    public static class Animal {
        public Animal(String name) {
            this.name = name;
        }

        public String name;
    }

    //Используется для установки имен типов, которые будут использоваться для аннотированного класса
    @JsonTypeName("dog")
    public static class Dog extends Animal {

        public double barkVolume;

        public Dog(String name) {
            super(name);
        }
    }

    //Используется для установки имен типов, которые будут использоваться для аннотированного класса
    @JsonTypeName("cat")
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;

        public Cat(String name) {
            super(name);
        }
    }
}