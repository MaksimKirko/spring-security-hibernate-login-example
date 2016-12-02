package com.websystique.springsecurity.service;


import com.websystique.springsecurity.model.Ticket;

import java.util.List;

/**
 * Created by Max on 29.11.2016.
 */
public interface ITicketService {

    Ticket getById(Long id);

    List<Ticket> getAll();

    void save(Ticket ticket);

    void delete(Long id);
}
