/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Check;

/**
 *
 * @author Ny Anjara Mamisoa
 */
@Entity
@Table (name="ticket")
@Check(constraints = " Upper(statut) IN (Upper('En cours'), Upper('Terminé'), Upper('Annulé'))")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String titre;
    @Column
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idutilisateur", referencedColumnName = "id" , nullable = true)
    @JsonManagedReference
    private User utilisateur;
    @Column
    private String statut;
    public Long getId() {
        return id;
    }
    
    public Ticket(){
        
    }

    public Ticket(String titre, String description, String statut) {
        this.titre = titre;
        this.description = description;
        this.statut = statut;
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

    public User getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(User utilisateur) {
        this.utilisateur = utilisateur;
    }
    
}
