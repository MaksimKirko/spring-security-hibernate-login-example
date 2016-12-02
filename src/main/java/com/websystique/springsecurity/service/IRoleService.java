package com.websystique.springsecurity.service;

import java.util.List;

import com.websystique.springsecurity.model.Role;

public interface IRoleService {

	List<Role> getAll();
	
	Role getByType(String type);
	
	Role getById(Long id);

	void save(Role role);

	void delete(Long id);
}
