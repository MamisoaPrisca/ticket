/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.app.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ticket.app.model.Ticket;
import ticket.app.repository.TicketRepository;

/**
 *
 * @author Ny Anjara Mamisoa
 */
@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;
    
    @GetMapping
    public ResponseEntity getTickets(){
        return new ResponseEntity<>(ticketRepository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getTickets(@PathVariable Long id){
        Optional<Ticket> optional= ticketRepository.findById(id);
        if(optional.isPresent()){
            return new ResponseEntity<>(optional.get(),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PostMapping
    public ResponseEntity insert(@RequestBody Ticket ticket){
        this.ticketRepository.save(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity insert(@PathVariable Long id,@RequestBody Ticket ticket){
        ticket.setId(id);
        this.ticketRepository.save(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
