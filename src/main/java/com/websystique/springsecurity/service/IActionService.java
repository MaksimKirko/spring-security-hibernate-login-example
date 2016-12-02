package com.websystique.springsecurity.service;


import com.websystique.springsecurity.model.User;
import com.websystique.springsecurity.model.action.Action;
import com.websystique.springsecurity.model.action.ActionEnum;

import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */
public interface IActionService {

    Action getById(Long id);

    List<Action> getByType(ActionEnum type);

    List<Action> getAll();

    void save(Action action);

    void delete(Long id);

}
