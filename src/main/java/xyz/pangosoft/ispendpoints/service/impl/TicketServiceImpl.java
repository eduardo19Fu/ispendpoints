package xyz.pangosoft.ispendpoints.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.pangosoft.ispendpoints.exception.exceptions.DataAccessException;
import xyz.pangosoft.ispendpoints.exception.exceptions.NoSuchElementException;
import xyz.pangosoft.ispendpoints.exception.exceptions.NotFoundException;
import xyz.pangosoft.ispendpoints.model.Ticket;
import xyz.pangosoft.ispendpoints.repository.ITicketRepository;
import xyz.pangosoft.ispendpoints.service.ITicketService;

import java.util.List;

@Service
public class TicketServiceImpl implements ITicketService {

    @Autowired
    private ITicketRepository ticketRepository;

    @Override
    public List<Ticket> findAll() {
        try {
            if (ticketRepository.findAll().size() > 0) {
                return ticketRepository.findAll();
            } else {
                throw new NoSuchElementException("No existen tickets registrados");
            }
        } catch (DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        }

    }

    @Override
    public Ticket findTicket(Integer id) {
        try {
            if (ticketRepository.findById(id).isPresent()) {
                return ticketRepository.findById(id).get();
            } else {
                throw new NotFoundException("No existe el usuario buscado.");
            }
        } catch (DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Ticket save(Ticket ticket) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
