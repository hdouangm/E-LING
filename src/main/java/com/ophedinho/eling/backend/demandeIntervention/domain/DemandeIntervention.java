/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.demandeIntervention.domain;

import static com.ophedinho.eling.backend.demandeIntervention.domain.DemandeIntervention.FIND_ALL;
import java.sql.Date;
import java.util.Calendar;
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
@NamedQuery(name = FIND_ALL, query = "SELECT dmi FROM DemandeIntervention dmi ORDER BY dmi.id DESC")
public class DemandeIntervention {
    
    public static final String FIND_ALL = "DemandeIntervention.findAll";
    
    ////////////////////////////////////////////////
  ////////         Attributs           //////////
  //////////////////////////////////////////////

  @Id
  @GeneratedValue
  private Long id;
  @NotNull
  @Column(nullable = false)
  private Long id_dmp;
  private Long type_intervention;
  private Date date;
  private boolean publication;

  ////////////////////////////////////////////////
  ////////         constructeurs       //////////
  //////////////////////////////////////////////

    public DemandeIntervention(Long id_dmp, Long type, Date date, boolean publication) {
        this.id_dmp = id_dmp;
        this.type_intervention = type;
        this.date = date;
        this.publication = publication;
    }

    public DemandeIntervention(Long id, Long id_dmp, Long type_intervention, boolean publication) {
        this.id = id;
        this.id_dmp = id_dmp;
        this.type_intervention = type_intervention;
        this.date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.publication = publication;
    }
    
    
    public DemandeIntervention(Long id_dmp, Long type, boolean publication) {
        this.id_dmp = id_dmp;
        this.type_intervention = type;
        this.date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.publication = publication;
    }

    public DemandeIntervention() {
        this.id_dmp = 1L;
        this.type_intervention = 2L;
        this.date = new java.sql.Date(Calendar.getInstance().getTime().getTime()); //new java.sql.Date(2019, 01, 31);
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

    public Long getType() {
        return type_intervention;
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
        this.type_intervention = type;
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
        sb.append("eling.Demande.intervention");
        sb.append("{id=").append(id);
        sb.append("{DMP=").append(id_dmp);
        sb.append(", Type='").append(type_intervention);
        sb.append(", date='").append(date);
        sb.append(", publication='").append(publication);
        return sb.toString();
    }
}
