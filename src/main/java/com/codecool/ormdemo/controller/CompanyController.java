package com.codecool.ormdemo.controller;

import com.codecool.ormdemo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {

    private final CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) { this.service = service; }

    @GetMapping("/companies")
    public String companies(Model model) {
        model.addAttribute("companies", service.getAll());
        return "companies";
    }


}
