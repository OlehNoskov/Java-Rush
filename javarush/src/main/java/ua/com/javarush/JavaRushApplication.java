package ua.com.javarush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaRushApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaRushApplication.class, args);
        System.out.println("It's working!!!");
    }
}