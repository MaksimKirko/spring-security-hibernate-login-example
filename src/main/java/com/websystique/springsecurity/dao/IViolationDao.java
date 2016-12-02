package com.websystique.springsecurity.dao;


import com.websystique.springsecurity.model.violation.Violation;
import com.websystique.springsecurity.model.violation.ViolationEnum;

import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */
public interface IViolationDao {

    Violation getById(Long id);

    List<Violation> getByType(ViolationEnum type);

    List<Violation> getAll();

    void save(Violation violation);

    void delete(Long id);
}
