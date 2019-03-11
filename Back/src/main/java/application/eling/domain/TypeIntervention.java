/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.eling.domain;

import static application.eling.domain.TypeIntervention.FIND_ALL;
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
@NamedQuery(name = TypeIntervention.FIND_ALL, query = "SELECT ti FROM TypeIntervention ti ORDER BY ti.id DESC")

public class TypeIntervention {
    
    public static final String FIND_ALL = "TypeIntervention.findAll";

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

    public TypeIntervention(String designation) {
        this.designation = designation;
    }

    public TypeIntervention() {
        this.designation = "Default designation";
    }
    
    ////////////////////////////////////////////////
    ////////         M�thodes       ///////////////
    //////////////////////////////////////////////

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
        sb.append("eling.typeIntervention");
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
        final TypeIntervention other = (TypeIntervention) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.designation, other.designation)) {
            return false;
        }
        return true;
    }
  
    
    
}
