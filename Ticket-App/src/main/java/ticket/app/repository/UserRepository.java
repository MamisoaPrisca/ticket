/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ticket.app.dto.UserDTO;
import ticket.app.model.User;

/**
 *
 * @author Ny Anjara Mamisoa
 */
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT new ticket.app.dto.UserDTO(t.id,t.username,t.email )FROM User t")
    public List<UserDTO> findAllUsers();
}
