package com.websystique.springsecurity.service;

import com.websystique.springsecurity.model.User;

import java.util.List;

public interface IUserService {

	User getById(Long id);

	User getByLogin(String login);

	List<User> getAll();

	void save(User user);

    void delete(Long id);
}