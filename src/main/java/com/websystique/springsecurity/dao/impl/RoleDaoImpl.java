package com.websystique.springsecurity.dao.impl;

import java.util.List;

import com.websystique.springsecurity.dao.IRoleDao;
import com.websystique.springsecurity.model.Role;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userProfileDao")
public class RoleDaoImpl extends AbstractDao<Long, Role>implements IRoleDao {

	@SuppressWarnings("unchecked")
	public List<Role> getAll(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("type"));
		return (List<Role>)crit.list();
	}
	
	public Role getById(Long id) {
		return getById(id);
	}
	
	public Role getByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		return (Role) crit.uniqueResult();
	}

	public void save(Role role) {
		save(role);
	}

    public void delete(Long id) {
        delete(id);
    }
}
