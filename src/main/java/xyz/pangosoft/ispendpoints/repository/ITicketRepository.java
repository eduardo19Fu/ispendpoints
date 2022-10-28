package xyz.pangosoft.ispendpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.pangosoft.ispendpoints.model.Ticket;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
}
