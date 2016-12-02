package com.websystique.springsecurity.service.impl;


import com.websystique.springsecurity.dao.ITicketDao;
import com.websystique.springsecurity.model.Ticket;
import com.websystique.springsecurity.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Max on 29.11.2016.
 */

@Service("ticketService")
@Transactional
public class TicketServiceImpl implements ITicketService {

    @Autowired
    private ITicketDao dao;

    public Ticket getById(Long id) {
        return dao.getById(id);
    }

    public List<Ticket> getAll() {
        return dao.getAll();
    }

    public void save(Ticket ticket){
        dao.save(ticket);
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}
