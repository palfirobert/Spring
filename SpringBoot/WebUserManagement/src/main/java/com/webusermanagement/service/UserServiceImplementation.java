package com.webusermanagement.service;

import com.webusermanagement.dao.RoleDAO;
import com.webusermanagement.dao.UserDAO;
import com.webusermanagement.entity.CrmUser;
import com.webusermanagement.entity.MyUserDetails;
import com.webusermanagement.entity.Role;
import com.webusermanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional
    public User findByUserName(String username) {
        return userDAO.findByUserName(username);
    }

    @Override
    @Transactional
    public void save(CrmUser crmUser) {
        User user=new User();
        user.setEmail(crmUser.getEmail());
        user.setFirstName(crmUser.getFirstName());
        user.setLastName(crmUser.getLastName());
        user.setUsername(crmUser.getUserName());
        user.setPassword(encoder.encode(crmUser.getPassword()));
        user.setRoles(Arrays.asList(roleDAO.findRoleByName("ROLE_USER")));
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void deleteByUsername(String username) {
        userDAO.deleteByUsername(username);
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public void update(User user,String roleName) {
        System.out.println(user.toString());
        userDAO.update(user,roleName);
    }

    @Override
    @Transactional
    public void changeRole(String roleName, String username) {
        userDAO.changeRole(roleName,username);
    }

    @Override
    @Transactional
    public void changePassword(User user, String newPassword) {
        userDAO.changePassword(user,newPassword);
    }

    @Override
    @Transactional
    public User findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userDAO.findByUserName(username);
        if(user==null)
            throw new UsernameNotFoundException("Could not find user "+username);
        return new MyUserDetails(user);
    }


}
