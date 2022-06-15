package ua.com.javarush.json.second_conversion;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

//Обрати внимание на аннотаци - Id.CLASS - полный путь класса в проэкте
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "className")
public abstract class Vehicle {
    protected String name;
    protected String owner;
    protected int age;
}