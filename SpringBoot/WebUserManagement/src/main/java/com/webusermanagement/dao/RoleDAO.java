package com.webusermanagement.dao;


import com.webusermanagement.entity.Role;

public interface RoleDAO {

	public Role findRoleByName(String theRoleName);

	
}
