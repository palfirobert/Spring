package com.webusermanagement.dao;

import com.webusermanagement.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserDAOImplementation implements UserDAO {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public User findByUserName(String username) {
        Session currentSession = entityManager.unwrap(Session.class);

        // now retrieve/read from database using username
        Query<User> theQuery = currentSession.createQuery("from User where username=:uName");
        theQuery.setParameter("uName", username);
        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }

    @Override
    public void save(User user) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(user);
    }

    @Override
    public void deleteByUsername(String username) {
        Session session = entityManager.unwrap(Session.class);
        Query query=session.createQuery("delete from User where username=:userName");
        query.setParameter("userName",username);
        query.executeUpdate();
    }

    @Override
    public List<User> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query=session.createQuery("from User");
        List<User>users=query.getResultList();
        return users;
    }

    @Override
    public void update(User user,String roleName) {
        Session currentSession = entityManager.unwrap(Session.class);
        user.setRoles(Arrays.asList(roleDAO.findRoleByName(roleName)));
        currentSession.update(user);
    }

    @Override
    public void changeRole(String roleName,String username) {
        Session currentSession = entityManager.unwrap(Session.class);
        User user=this.findByUserName(username);
        user.setRoles(Arrays.asList(roleDAO.findRoleByName(roleName)));
        currentSession.update(user);
    }

    @Override
    public void changePassword(User user, String newPassword) {
        Session currentSession = entityManager.unwrap(Session.class);
        user.setPassword(encoder.encode(newPassword));
        currentSession.update(user);
    }

    @Override
    public User findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> theQuery = currentSession.createQuery("from User where id=:userId");
        theQuery.setParameter("userId", id);
        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }


}
