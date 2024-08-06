/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.app.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ny Anjara Mamisoa
 */
@RestController
@RequestMapping("/test")
public class HelloController {
    @GetMapping
    public ResponseEntity test() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
