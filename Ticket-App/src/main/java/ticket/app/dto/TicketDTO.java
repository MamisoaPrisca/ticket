/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.app.dto;

import ticket.app.model.Ticket;
import ticket.app.model.User;

/**
 *
 * @author Ny Anjara Mamisoa
 */
public class TicketDTO {
    private Long id;
    private String titre;
    private String description;
    private String statut;
    private Long userId; 
    private String username;
    private String email;
    public TicketDTO(){
        
    }
    
    public Ticket generateTicket(){
        return new Ticket(titre, description, statut);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public TicketDTO(Long id, String titre, String description, String statut, Long userId, String username, String email) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.statut = statut;
        this.userId = userId;
        this.username = username;
        this.email = email;
    }
    
    
}
