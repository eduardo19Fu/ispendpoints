package xyz.pangosoft.ispendpoints.service;

import xyz.pangosoft.ispendpoints.model.Ticket;

import java.util.List;

public interface ITicketService {

    public List<Ticket> findAll();

    public Ticket findTicket(Integer id);

    public Ticket save(Ticket ticket);

    public void delete(Integer id);
}
