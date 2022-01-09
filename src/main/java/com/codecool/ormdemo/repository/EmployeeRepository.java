package com.codecool.ormdemo.repository;

import com.codecool.ormdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstNameStartsWith(String firstName);

    Optional<Employee> findByLastNameIsContainingAndFirstNameIsOrderByIdDesc(String lastName, String firstName);
}
