/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.demandeIntervention.domain;

import static com.ophedinho.eling.backend.demandeIntervention.domain.DemandeIntervention.FIND_ALL;
import static com.ophedinho.eling.backend.demandeIntervention.domain.DemandeIntervention.FIND_ALL_LAB;
import static com.ophedinho.eling.backend.demandeIntervention.domain.DemandeIntervention.FIND_ALL_MED;
import java.sql.Date;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ophedinho
 */

@Entity
//@NamedQuery(name = FIND_ALL, query = "SELECT dmi FROM DemandeIntervention dmi ORDER BY dmi.id DESC")
@NamedQueries({
    @NamedQuery(name = FIND_ALL, query = "SELECT dmi FROM DemandeIntervention dmi ORDER BY dmi.id DESC"),
    @NamedQuery(name = FIND_ALL_MED, query = "SELECT dmi FROM DemandeIntervention dmi WHERE dmi.publicationMed=0 ORDER BY dmi.id DESC"),
    @NamedQuery(name = FIND_ALL_LAB, query = "SELECT dmi FROM DemandeIntervention dmi WHERE dmi.publicationLab=0 ORDER BY dmi.id DESC")
})
public class DemandeIntervention {
    
    public static final String FIND_ALL = "DemandeIntervention.findAll";
    public static final String FIND_ALL_MED = "DemandeIntervention.findAllMed";
    public static final String FIND_ALL_LAB = "DemandeIntervention.findAllLab";
    
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
  private String date;
  private boolean publicationMed;
  private boolean publicationLab;

  ////////////////////////////////////////////////
  ////////         constructeurs       //////////
  //////////////////////////////////////////////

    public DemandeIntervention(Long id, Long id_dmp, Long type_intervention, boolean publication, boolean publicationLab) {
        this.id = id;
        this.id_dmp = id_dmp;
        this.type_intervention = type_intervention;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        this.date = sdf.format(new java.util.Date(Calendar.getInstance().getTime().getTime()));
        this.publicationMed = publication;
        this.publicationLab = publicationLab;
    }
    
    public DemandeIntervention(Long id_dmp, Long type_intervention, boolean publication) {
        this.id_dmp = id_dmp;
        this.type_intervention = type_intervention;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        this.date = sdf.format(new java.util.Date(Calendar.getInstance().getTime().getTime()));
        this.publicationMed = publication;
        this.publicationLab = false;
    }
    
    public DemandeIntervention(Long id_dmp, Long type_intervention, boolean publication, boolean publicationLab) {
        this.id_dmp = id_dmp;
        this.type_intervention = type_intervention;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        this.date = sdf.format(new java.util.Date(Calendar.getInstance().getTime().getTime()));
        this.publicationMed = publication;
        this.publicationLab = false;
    }

    public DemandeIntervention() {
        this.id_dmp = 1L;
        this.type_intervention = 2L;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        this.date = sdf.format(new java.util.Date(Calendar.getInstance().getTime().getTime()));
        this.publicationMed = true;
        this.publicationLab = false;
    }

  
  ////////////////////////////////////////////////
  ////////         M�thodes            //////////
  //////////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public Long getId_dmp() {
        return id_dmp;
    }


    public String getDate() {
        return date;
    }
    
    public boolean isPublication() {
        return publicationMed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId_dmp(Long id_dmp) {
        this.id_dmp = id_dmp;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPublication(boolean publication) {
        this.publicationMed = publication;
    }

    public Long getType_intervention() {
        return type_intervention;
    }

    public boolean isPublicationMed() {
        return publicationMed;
    }

    public boolean isPublicationLab() {
        return publicationLab;
    }

    public void setType_intervention(Long type_examen) {
        this.type_intervention = type_examen;
    }

    public void setPublicationMed(boolean publicationMed) {
        this.publicationMed = publicationMed;
    }

    public void setPublicationLab(boolean publicationLab) {
        this.publicationLab = publicationLab;
    }
        

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("eling.Demande.examen");
        sb.append("{id=").append(id);
        sb.append("{DMP=").append(id_dmp);
        sb.append(",type_examen='").append(type_intervention);
        sb.append(", date='").append(date);
        sb.append(", publicationMed='").append(publicationMed);
        sb.append(", publicationLab='").append(publicationLab);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.id_dmp);
        hash = 53 * hash + Objects.hashCode(this.type_intervention);
        hash = 53 * hash + Objects.hashCode(this.date);
        hash = 53 * hash + (this.publicationMed ? 1 : 0);
        hash = 53 * hash + (this.publicationLab ? 1 : 0);
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
        final DemandeIntervention other = (DemandeIntervention) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.id_dmp, other.id_dmp)) {
            return false;
        }
        if (!Objects.equals(this.type_intervention, other.type_intervention)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (this.publicationMed != other.publicationMed) {
            return false;
        }
        if (this.publicationLab != other.publicationLab) {
            return false;
        }
        return true;
    }
}