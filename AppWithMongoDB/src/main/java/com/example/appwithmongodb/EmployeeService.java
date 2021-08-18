package com.example.appwithmongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class EmployeeService {

    @Autowired
    public EmployeeRepo repo;

    public void standardMethods() {

        //insert
        Employee newEmp = new Employee(10, "Pera", 15000, "Zaklopaca");
        newEmp = repo.save(newEmp);
        System.out.printf("Inserted new employee id %d:\n", newEmp.getEmployeeId());

        System.out.printf("Count of employees %d:\n", repo.count());

        displayEmployees("All employees:\n", repo.findAll());
    }

    public void customMethods() {

        //emp by region
        displayEmployees("Employees by region 'Beograd':", repo.findByRegion("Beograd"));


        //emp by salary range
        List<Employee> emps = repo.findInSalaryRange(1000, 1500);
        displayEmployees("Employees by salary range 1000-1500:", emps);

        //emp by grater salary
        Pageable pageable = PageRequest.of(1, 3, Direction.ASC, "salary");
        Page<Employee> employeePage = repo.findByPlataGreaterThan(1200, pageable);
        displayEmployees("Employees with salary greater than 1200:", employeePage.getContent());

    }

    private void displayEmployees(String message, Iterable<Employee> employees) {
        System.out.printf("\n%s\n", message);
        for(Employee emp: employees) {
            System.out.println(emp);
        }
    }
}
