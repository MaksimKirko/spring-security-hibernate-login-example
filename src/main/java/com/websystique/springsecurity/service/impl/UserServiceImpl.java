package com.websystique.springsecurity.service.impl;

import com.websystique.springsecurity.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.IUserDao;
import com.websystique.springsecurity.model.User;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User getById(Long id) {
		return dao.getById(id);
	}

	public User getByLogin(String login) {
		return dao.getByLogin(login);
	}

	public List<User> getAll() {
		return dao.getAll();
	}

	public void save(User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}

    public void delete(Long id) {
        dao.delete(id);
    }

}
