package com.webusermanagement.dao;

import com.webusermanagement.entity.User;

import java.util.List;

public interface UserDAO {
    public User findByUserName(String username);
    public void save(User user);
    public void deleteByUsername(String username);
    public List<User> findAll();
    public void update(User user,String roleName);

    public void changeRole(String roleName,String username);
}
