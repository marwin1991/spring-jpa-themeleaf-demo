package com.codecool.ormdemo.service;


import com.codecool.ormdemo.model.Company;
import com.codecool.ormdemo.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) { this.repository = repository; }

    public List<Company> getAll(){
        return repository.findAll();
    }

    public void save(Company company){
        repository.save(company);
    }


}
