package com.example.appwithmongodb;

import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryDependsOnPostProcessor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Employee {

    @Id
    private long employeeId = -1;

    private String name;
    private String region;

    @Field("salary")
    private double plata;

    public Employee() {

    }
    public Employee(int employeeId, String name, double plata, String region) {

        this.employeeId = employeeId;
        this.name = name;
        this.plata = plata;
        this.region = region;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public double getPlata() {
        return plata;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", plata=" + plata +
                '}';
    }
}
