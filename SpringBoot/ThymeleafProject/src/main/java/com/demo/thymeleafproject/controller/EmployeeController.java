package com.demo.thymeleafproject.controller;

import com.demo.thymeleafproject.entity.Employee;
import com.demo.thymeleafproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/list")
    public String listEmployees(Model model){
        List<Employee>employees=employeeService.findAll();
        model.addAttribute("employees",employees);
        return "list-employees";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee)
    {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id,Model model){
        Employee employee=employeeService.findById(id);
        model.addAttribute("employee",employee);
        return "employee-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id)
    {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
