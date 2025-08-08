package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Needed for @Autowired to work
public class EmployeeServiceImp1 implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    // List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        // employees.add(employee);
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Saved Successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeeList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeList) {
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        // EmployeeEntity emp= employeeRepository.findById(id).get();
        // employeeRepository.delete(emp);

        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        // TODO Auto-generated method stub
        EmployeeEntity existingEmployee = employeeRepository.findById(id).get();
        
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setName(employee.getName());
        existingEmployee.setPhone(employee.getPhone());

        employeeRepository.save(existingEmployee);

        return "Update Successfully";
    }

    @Override
    public Employee readEmployee(Long id) {
        // TODO Auto-generated method stub
        EmployeeEntity employeeEntity= employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

}
