package com.springdemo.springboothibernaterest.dao;

import com.springdemo.springboothibernaterest.entity.Employee;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);
}
