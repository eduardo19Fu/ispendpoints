package xyz.pangosoft.ispendpoints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.pangosoft.ispendpoints.model.Ticket;
import xyz.pangosoft.ispendpoints.service.ITicketService;

@CrossOrigin(value = {"*"})
@RestController
@RequestMapping("/api")
public class TicketApiController {

    @Autowired
    private ITicketService ticketService;

    @GetMapping("/tickets/get")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(ticketService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/tickets/get/{id}")
    public ResponseEntity<?> findTicket(@PathVariable Integer id) {
        return new ResponseEntity<>(ticketService.findTicket(id), HttpStatus.OK);
    }

    @PostMapping("/tickets/post")
    public ResponseEntity<?> create(@RequestBody Ticket ticket) {
        return new ResponseEntity<>(ticketService.save(ticket), HttpStatus.CREATED);
    }
}