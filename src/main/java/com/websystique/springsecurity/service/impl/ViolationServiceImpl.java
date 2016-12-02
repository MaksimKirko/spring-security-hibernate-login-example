package com.websystique.springsecurity.service.impl;


import com.websystique.springsecurity.dao.IViolationDao;
import com.websystique.springsecurity.model.violation.Violation;
import com.websystique.springsecurity.model.violation.ViolationEnum;
import com.websystique.springsecurity.service.IViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */
@Service("violationService")
@Transactional
public class ViolationServiceImpl implements IViolationService {

    @Autowired
    private IViolationDao dao;

    public Violation getById(Long id) {
        return dao.getById(id);
    }

    public List<Violation> getByType(ViolationEnum type) {
        return dao.getByType(type);
    }

    public List<Violation> getAll() {
        return dao.getAll();
    }

    public void save(Violation violation){
        dao.save(violation);
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}
