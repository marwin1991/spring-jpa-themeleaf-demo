package com.codecool.ormdemo.controller;

import com.codecool.ormdemo.model.Company;
import com.codecool.ormdemo.model.Employee;
import com.codecool.ormdemo.service.CompanyService;
import com.codecool.ormdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, CompanyService companyService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/employees")
    public String employees(@RequestParam(required = false, defaultValue = "-1") Long companyId, Model model){
        List<Company> companies = companyService.getAll();
        model.addAttribute("companies", companies);

        Optional<Company> optionalCompany = companies.stream()
                .filter(company -> company.getId().equals(companyId))
                .findFirst();

        if(optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            model.addAttribute("employees", company.getEmployees());
            model.addAttribute("chosenCompanyName", company.getName());
        } else {
            model.addAttribute("employees", employeeService.getAll());
            model.addAttribute("chosenCompanyName", "");
        }
        return "employees";
    }


    @GetMapping("/add_employee")
    public String displayAddEmployee(Employee employee, Model model){
        model.addAttribute("companies", companyService.getAll());
        return "add_employee";
    }

    @PostMapping("/add_employee")
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model) {
        model.addAttribute("companies", companyService.getAll());
        if (result.hasErrors()) {
            return "add_employee";
        }

        employeeService.save(employee);
        return "redirect:/employees";
    }
}
