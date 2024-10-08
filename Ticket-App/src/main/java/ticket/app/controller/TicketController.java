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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ticket.app.dto.TicketDTO;
import ticket.app.model.Ticket;
import ticket.app.model.User;
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
        return new ResponseEntity<>(ticketRepository.findAllTickets(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getTickets(@PathVariable Long id){
        TicketDTO ticket= ticketRepository.findTicketById(id);
        if(ticket==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity insert(@RequestBody TicketDTO ticket){
        this.ticketRepository.save(ticket.generateTicket());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity insert(@PathVariable Long id,@RequestBody Ticket ticket){
        ticket.setId(id);
        this.ticketRepository.save(ticket);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/{id}/assign/{useId}")
    public ResponseEntity assingTicket(@PathVariable Long id,@PathVariable Long useId){
        this.ticketRepository.assingTicket(id, useId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        TicketDTO ticket= ticketRepository.findTicketById(id);
        if(ticket==null){
            return new ResponseEntity<>("Ce ticket n'existe pas ",HttpStatus.NOT_FOUND);
        }
        ticketRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
