/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ticket.app.model.User;

/**
 *
 * @author Ny Anjara Mamisoa
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
}
