package com.websystique.springsecurity.dao.impl;


import com.websystique.springsecurity.dao.ITicketDao;
import com.websystique.springsecurity.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Max on 29.11.2016.
 */
@Repository("ticketDao")
public class TicketDaoImpl extends AbstractDao<Long, Ticket> implements ITicketDao {

    public Ticket getById(Long id) {
        return getById(id);
    }

    public List<Ticket> getAll() {
        return getAll();
    }

    public void save(Ticket ticket) {
        save(ticket);
    }

    public void delete(Long id) {
        delete(id);
    }
}
