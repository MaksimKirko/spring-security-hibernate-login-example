package com.websystique.springsecurity.dao.impl;


import com.websystique.springsecurity.dao.IViolationDao;
import com.websystique.springsecurity.model.violation.Violation;
import com.websystique.springsecurity.model.violation.ViolationEnum;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */

@Repository("violationDao")
public class ViolationDaoImpl extends AbstractDao<Long, Violation> implements IViolationDao {

    public Violation getById(Long id) {
        return getById(id);
    }

    public List<Violation> getByType(ViolationEnum type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return crit.list();
    }

    public List<Violation> getAll() {
        return getAll();
    }

    public void save(Violation violation) {
        save(violation);
    }

    public void delete(Long id) {
        delete(id);
    }
}
