package ua.com.javarush.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;

//Десериализация JSON обьекта
public class Deserializable {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        //Обьект Jackson, выполняет десериализацию
        ObjectMapper objectMapper = new ObjectMapper();
        // возвращаем обьект Java конвертированный из JSON
        return objectMapper.readValue(new FileReader(fileName), clazz);
    }

    public static void main(String[] args) {

    }
}