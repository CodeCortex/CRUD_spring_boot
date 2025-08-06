package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service  // Needed for @Autowired to work
public class EmployeeServiceImp1 implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        employees.add(employee);
        return "Saved Successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return employees.removeIf(emp -> emp.getId().equals(id));
        // employees.remove(id);
        // return true;
    }
}
