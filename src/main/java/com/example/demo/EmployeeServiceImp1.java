package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImp1 implements EmployeeService {

    List<Employee> employees= new ArrayList<>();
    @Override
    public String createEmployee(Employee employee) {
        // TODO Auto-generated method stub
        employees.add(employee);
        return "Saved Successfully";


    }

    @Override
    public List<Employee> readEmployees() {
        // TODO Auto-generated method stub
        return employees;

    }

    @Override
    public boolean deleteEmployee(Long id) {
        // TODO Auto-generated method stub

        employees.remove(id);
        return true;

    }

}
