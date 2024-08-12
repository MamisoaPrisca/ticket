/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.app.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ticket.app.model.Ticket;


/**
 *
 * @author Ny Anjara Mamisoa
 */
public interface TicketRepository extends JpaRepository<Ticket, Long>{
    
    @Modifying
    @Transactional
    @Query("update Ticket t set t.utilisateur.id =:userId where t.id =:id")
    public void assingTicket(@Param("id") Long id,  @Param("userId") Long userId);
    
    @Query("SELECT t FROM Ticket t JOIN FETCH t.utilisateur")
    public List<Ticket> findAllTickets();
    
    @Query("SELECT t FROM Ticket t JOIN FETCH t.utilisateur WHERE t.id = :id")
    public Ticket findTicketById(@Param("id") Long id);
}
