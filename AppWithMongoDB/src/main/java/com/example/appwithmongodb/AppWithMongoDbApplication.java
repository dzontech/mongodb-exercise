package com.example.appwithmongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppWithMongoDbApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(AppWithMongoDbApplication.class, args);

        EmployeeService s = ctx.getBean(EmployeeService.class);


        s.standardMethods();
        s.customMethods();
    }

}
