package com.codecool.ormdemo.service;

import com.codecool.ormdemo.model.Employee;
import com.codecool.ormdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.repository = employeeRepository;
    }

    public List<Employee> getAll(){
        return repository.findAll();
    }

    public void save(Employee employee){
        repository.save(employee);
    }
}
