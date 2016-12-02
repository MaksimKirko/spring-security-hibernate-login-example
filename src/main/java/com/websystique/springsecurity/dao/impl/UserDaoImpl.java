package com.websystique.springsecurity.dao.impl;

import com.websystique.springsecurity.dao.IUserDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Long, User> implements IUserDao {

	public User getById(Long id) {
		return getById(id);
	}

	public User getByLogin(String login) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("login", login));
		return (User) crit.uniqueResult();
	}

	public void save(User user) {
		save(user);
	}

	public void delete(Long id) {
		delete(id);
	}

}
