package com.employee.SpringBootCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.employee.SpringBootCrud.service")
public class SpringBootCrudEmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrudEmpApplication.class, args);
        
    }
}

