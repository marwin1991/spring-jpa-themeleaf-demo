package com.codecool.ormdemo.dao.implemention;

import com.codecool.ormdemo.dao.EmployeeDao;
import com.codecool.ormdemo.model.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDaoMem implements EmployeeDao {

    @Override
    public void save(Employee employee) {

    }
}
