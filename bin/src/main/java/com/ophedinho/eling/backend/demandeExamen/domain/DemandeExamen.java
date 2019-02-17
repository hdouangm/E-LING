/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.demandeExamen.domain;


import static com.ophedinho.eling.backend.demandeExamen.domain.DemandeExamen.FIND_ALL;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ophedinho
 */


@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT dme FROM DemandeExamen dme ORDER BY dme.id DESC")

public class DemandeExamen {
    
    public static final String FIND_ALL = "DemandeExamen.findAll";
    
  ////////////////////////////////////////////////
  ////////         Attributs           //////////
  //////////////////////////////////////////////

  @Id
  @GeneratedValue
  private Long id;
  @NotNull
  @Column(nullable = false)
  private Long id_dmp;
  private String type_examen;
  private Date date;
  private boolean publication;

  ////////////////////////////////////////////////
  ////////         constructeurs       //////////
  //////////////////////////////////////////////

    public DemandeExamen(Long id_dmp, String type, Date date, boolean publication) {
        this.id_dmp = id_dmp;
        this.type_examen = type;
        this.date = date;
        this.publication = publication;
    }

    public DemandeExamen() {
        this.id_dmp = 1L;
        this.type_examen = "Default";
        this.date = new Date();
        this.publication = true;
    }

  
  ////////////////////////////////////////////////
  ////////         Mthodes            //////////
  //////////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public Long getId_dmp() {
        return id_dmp;
    }

    public String getType() {
        return type_examen;
    }

    public Date getDate() {
        return date;
    }

    public boolean isPublication() {
        return publication;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId_dmp(Long id_dmp) {
        this.id_dmp = id_dmp;
    }

    public void setType(String type) {
        this.type_examen = type;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPublication(boolean publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("eling.Demande.examen");
        sb.append("{id=").append(id);
        sb.append("{DMP=").append(id_dmp);
        sb.append(", Type='").append(type_examen);
        sb.append(", date='").append(date);
        sb.append(", publication='").append(publication);
        return sb.toString();
    }
   
    
  
}
