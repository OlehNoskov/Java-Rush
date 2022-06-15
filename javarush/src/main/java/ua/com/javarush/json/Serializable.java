package ua.com.javarush.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class Serializable {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 3;

        //пишем результаты сериализации в StringWriter
        StringWriter writer = new StringWriter();
        convertToJSON(writer, cat);
        System.out.println(writer);
    }

    public static void convertToJSON(StringWriter writer, Object object) throws IOException {
        //Обьект Jackson, выполняет сериализацию
        ObjectMapper mapper = new ObjectMapper();
        //сама сериализация: writer-куда, object - что пишем
        mapper.writeValue(writer, object);
    }

    //Аннотация помечает что класс готов к сериализации в JSON
    @JsonAutoDetect
    public static class Cat {

        //Аннотация позовляет задать другое имя поля при сериализации
        @JsonProperty("wildAnimal")
        public String name;

        //Аннотация помечает что поле игнороируется при сериализации(не записывается)
        @JsonIgnore
        public int age;

        //Аннотация позовляет задать другое имя поля при сериализации
        @JsonProperty("over")
        public int weight;

        Cat() {
        }
    }
}