/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.domain;

import static com.ophedinho.eling.backend.domain.TypeExamen.FIND_ALL;
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
@NamedQuery(name = FIND_ALL, query = "SELECT te FROM TypeExamen te ORDER BY te.id DESC")

public class TypeExamen {
    
    public static final String FIND_ALL = "TypeExamen.findAll";

  ////////////////////////////////////////////////
  ////////         Attributs           //////////
  //////////////////////////////////////////////

  @Id
  @GeneratedValue
  private Long id;
  @NotNull
  @Column(nullable = false)
  private String designation;
  

  ////////////////////////////////////////////////
  ////////         constructeurs       //////////
  //////////////////////////////////////////////

    public TypeExamen(String designation) {
        this.designation = designation;
    }

    public TypeExamen() {
        this.designation = "Default designation";
    }

    public Long getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("eling.typeExamen");
        sb.append("{id=").append(id);
        sb.append(", Designation='").append(designation);
        return sb.toString();
  }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.designation);
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
        final TypeExamen other = (TypeExamen) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.designation, other.designation)) {
            return false;
        }
        return true;
    }
  
    
    
}
