package com.webusermanagement.service;

import com.webusermanagement.entity.CrmUser;
import com.webusermanagement.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public User findByUserName(String username);
    public void save(CrmUser crmUser);

    public void deleteByUsername(String username);
    public List<User> findAll();
    public void update(User user,String roleName);
    public void changeRole(String roleName,String username);

    public void changePassword(User user,String newPassword);
}
