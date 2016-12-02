package com.websystique.springsecurity.dao;

import com.websystique.springsecurity.model.User;

import java.util.List;

public interface IUserDao {

	User getById(Long id);

	User getByLogin(String login);

	List<User> getAll();

	void save(User user);

    void delete(Long id);
}

