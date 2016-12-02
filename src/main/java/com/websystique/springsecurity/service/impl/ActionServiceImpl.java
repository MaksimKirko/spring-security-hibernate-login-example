package com.websystique.springsecurity.service.impl;


import com.websystique.springsecurity.dao.IActionDao;
import com.websystique.springsecurity.model.action.Action;
import com.websystique.springsecurity.model.action.ActionEnum;
import com.websystique.springsecurity.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */

@Service("actionService")
@Transactional
public class ActionServiceImpl implements IActionService {

    @Autowired
    private IActionDao dao;

    public Action getById(Long id) {
        return dao.getById(id);
    }

    public List<Action> getByType(ActionEnum type) {
        return dao.getByType(type);
    }

    public List<Action> getAll() {
        return dao.getAll();
    }

    public void save(Action action){
        dao.save(action);
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}