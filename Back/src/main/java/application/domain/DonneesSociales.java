/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.domain;

import static application.domain.DonneesSociales.FIND_ALL;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author asus
 */
@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT d FROM DonneesSociales d ORDER BY d.id")
public class DonneesSociales {
    
     public static final String FIND_ALL = "DonneesSociales.findAllDonneesSociales";
     
    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(nullable = false)
    private String nom;
    private String prenom;
    private String adresse;
    
      // ======================================
  // =            Constructors            =
  // ======================================
    
    public DonneesSociales() {}

    public DonneesSociales(String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }
    
    
    
  // ======================================
  // =          Getters & Setters         =
 // ======================================

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

 
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
  
  @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("application.donneessociales.DonneesSociales");
        sb.append("{id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom=").append(prenom).append('\'');
        sb.append(", adresse=").append(adresse);
        sb.append('}');
        return sb.toString();
    }
}