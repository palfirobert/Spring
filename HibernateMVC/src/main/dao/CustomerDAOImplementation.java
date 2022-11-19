package main.dao;

import main.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class CustomerDAOImplementation implements CustomerDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session session=sessionFactory.getCurrentSession();
        Query<Customer>customerQuery=session.createQuery("from Customer order by lastName",Customer.class);
        List<Customer> customers=customerQuery.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer); //in caz de exista il creeaza, daca nu ii da update
    }

    @Override
    public Customer getCustomer(int id) {
        Session session=sessionFactory.getCurrentSession();
        Customer customer=session.get(Customer.class,id);
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId",id);
        query.executeUpdate();
    }

}
