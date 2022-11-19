package com.springdemo.springboothibernaterest.rest;

import com.springdemo.springboothibernaterest.dao.EmployeeDAO;
import com.springdemo.springboothibernaterest.entity.Employee;
import com.springdemo.springboothibernaterest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee employee=employeeService.findById(employeeId);
        if(employee==null)
            throw new RuntimeException("Employee not found");
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee employee=employeeService.findById(employeeId);
        if(employee==null)
            throw new RuntimeException("Employee not found");
        employeeService.deleteById(employeeId);
        return "Employee deleted";
    }
}
