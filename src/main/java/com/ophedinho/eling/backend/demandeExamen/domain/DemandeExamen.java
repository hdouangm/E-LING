/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.demandeExamen.domain;


import static com.ophedinho.eling.backend.demandeExamen.domain.DemandeExamen.FIND_ALL;
import java.sql.Date;
import java.util.Calendar;
import java.util.Objects;
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
  private Long type_examen;
  private Date date;
  private boolean publication;

  ////////////////////////////////////////////////
  ////////         constructeurs       //////////
  //////////////////////////////////////////////

    public DemandeExamen(Long id, Long id_dmp, Long type_examen, boolean publication) {
        this.id = id;
        this.id_dmp = id_dmp;
        this.type_examen = type_examen;
        this.date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.publication = publication;
    }
  
  

    public DemandeExamen(Long id_dmp, Long type, Date date, boolean publication) {
        this.id_dmp = id_dmp;
        this.type_examen = type;
        this.date = date;
        this.publication = publication;
    }
    
    public DemandeExamen(Long id_dmp, Long type, boolean publication) {
        this.id_dmp = id_dmp;
        this.type_examen = type;
        this.date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.publication = publication;
    }

    public DemandeExamen() {
        this.id_dmp = 1L;
        this.type_examen = 2L;
        this.date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.publication = true;
    }

  
  ////////////////////////////////////////////////
  ////////         Méthodes            //////////
  //////////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public Long getId_dmp() {
        return id_dmp;
    }

    public Long getType() {
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

    public void setType(Long type) {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.id_dmp);
        hash = 53 * hash + Objects.hashCode(this.type_examen);
        hash = 53 * hash + Objects.hashCode(this.date);
        hash = 53 * hash + (this.publication ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DemandeExamen other = (DemandeExamen) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.id_dmp, other.id_dmp)) {
            return false;
        }
        if (!Objects.equals(this.type_examen, other.type_examen)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (this.publication != other.publication) {
            return false;
        }
        return true;
    }

    
   
    
  
}
