package ru.weatherreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherReactiveApplication.class, args);
        System.out.println("http://localhost:8080/");
    }
}
