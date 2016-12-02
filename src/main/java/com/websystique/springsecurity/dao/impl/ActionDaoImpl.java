package com.websystique.springsecurity.dao.impl;


import com.websystique.springsecurity.dao.IActionDao;
import com.websystique.springsecurity.model.action.Action;
import com.websystique.springsecurity.model.action.ActionEnum;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("actionDao")
public class ActionDaoImpl extends AbstractDao<Long, Action> implements IActionDao {

    public Action getById(Long id) {
        return getById(id);
    }

    public List<Action> getByType(ActionEnum type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return crit.list();
    }

    public List<Action> getAll() {
        return getAll();
    }

    public void save(Action action) {
        save(action);
    }

    public void delete(Long id) {
        delete(id);
    }
}