package com.springdemo.springboothibernaterest.dao;

import com.springdemo.springboothibernaterest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO{

    private EntityManager entityManager;//creat automat de SpringBoot

    @Autowired
    public EmployeeDAOImplementation(EntityManager entityManager) //constructor injection
    {
        this.entityManager=entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Session session=entityManager.unwrap(Session.class);
        Query<Employee>employeeQuery=session.createQuery("from Employee", Employee.class);
        List<Employee>employees=employeeQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Session session=entityManager.unwrap(Session.class);
        Employee employee=session.get(Employee.class,id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        Session session=entityManager.unwrap(Session.class);
        Query query=session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();
    }
}
