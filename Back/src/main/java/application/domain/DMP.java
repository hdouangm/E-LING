/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.domain;

import static application.domain.DMP.FIND_ALL;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author asus
 */
@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT d FROM DMP d ")
public class DMP {
    
    public static final String FIND_ALL = "DMP.findAllDonneesSociales";
     
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(nullable = false)
    private String numeroSS;

    public DMP() {
    }
    
    

    public DMP(String numeroSS) {
        this.numeroSS = numeroSS;
    }

    public DMP(Long id, String numeroSS) {
        this.id = id;
        this.numeroSS = numeroSS;
    }
    
    

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(String numeroSS) {
        this.numeroSS = numeroSS;
    }

    @Override
    public String toString() {
        return "DMP{" + "id=" + id + ", numeroSS=" + numeroSS + '}';
    }
    
    
}
