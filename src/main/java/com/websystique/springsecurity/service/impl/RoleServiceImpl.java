package com.websystique.springsecurity.service.impl;

import java.util.List;

import com.websystique.springsecurity.model.Role;
import com.websystique.springsecurity.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.IRoleDao;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
    IRoleDao dao;

	public Role getByType(String type){
		return dao.getByType(type);
	}

	public Role getById(Long id) {
		return dao.getById(id);
	}

	public List<Role> getAll() {
		return dao.getAll();
	}

	public void save(Role role) {
		dao.save(role);
	}

	public void delete(Long id) {
		dao.delete(id);
	}

}
