package com.example.appwithmongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SeedDb {

    @Autowired
    public EmployeeRepo repo;

    @PostConstruct
    public void init() {
        repo.save(new Employee(1, "Jovan", 1000, "Beograd"));
        repo.save(new Employee(2, "Sanja", 1500, "Beograd"));
        repo.save(new Employee(3, "Bojan", 1200, "Kraljevo"));
        repo.save(new Employee(4, "Marko", 1600, "Nis"));
        repo.save(new Employee(5, "Ivan", 1300, "Gornji Milanovac"));
        repo.save(new Employee(6, "Nenad", 1300, "Cacak"));
    }

    @PreDestroy
    public void cleanup() {
        repo.deleteAll();
    }
}
