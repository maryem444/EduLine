package com.example.perfectionnement.eduLine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.perfectionnement.eduLine")
public class EduLineApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduLineApplication.class, args);
    }

}
