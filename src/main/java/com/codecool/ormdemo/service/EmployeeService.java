package com.codecool.ormdemo.service;

import com.codecool.ormdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.repository = employeeRepository;
    }
}
