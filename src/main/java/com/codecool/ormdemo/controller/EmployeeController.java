package com.codecool.ormdemo.controller;

import com.codecool.ormdemo.model.Employee;
import com.codecool.ormdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/employees")
    public String employees(Model model){
        model.addAttribute("employees", employeeService.getAll());
        return "employees";
    }


    @GetMapping("/add_employee")
    public String displayAddEmployee(Employee employee, Model model){
        return "add_employee";
    }

    @PostMapping("/add_employee")
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add_employee";
        }

        employeeService.save(employee);
        return "redirect:/employees";
    }
}
