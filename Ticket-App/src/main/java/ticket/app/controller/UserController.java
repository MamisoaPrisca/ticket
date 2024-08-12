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
import ticket.app.model.User;
import ticket.app.repository.UserRepository;

/**
 *
 * @author Ny Anjara Mamisoa
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping
    public ResponseEntity insert(@RequestBody User utilisateur){
        this.userRepository.save(utilisateur);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody User utilisateur){
        utilisateur.setId(id);
        this.userRepository.save(utilisateur);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}/ticket")
    public ResponseEntity getUser(@PathVariable Long id){
        Optional<User>optinal= userRepository.findById(id);
        if(!optinal.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(optinal.get(), HttpStatus.OK);
        
    }
    
    @GetMapping
    public ResponseEntity getUsers(){
        return new ResponseEntity<>(userRepository.findAllUsers(), HttpStatus.OK);
    }
    
    
}
