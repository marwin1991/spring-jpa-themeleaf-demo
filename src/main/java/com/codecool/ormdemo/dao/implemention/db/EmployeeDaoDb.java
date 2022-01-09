package com.codecool.ormdemo.dao.implemention.db;

import com.codecool.ormdemo.dao.EmployeeDao;
import com.codecool.ormdemo.model.Employee;
import com.codecool.ormdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class EmployeeDaoDb implements EmployeeDao {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeDaoDb(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }
}
