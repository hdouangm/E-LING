/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.domain;

import static com.ophedinho.eling.backend.domain.CompteAphp.FIND_ALL;
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
@NamedQuery(name = FIND_ALL, query = "SELECT cp FROM CompteAphp cp ORDER BY cp.id DESC")
/*@NamedQueries({
    @NamedQuery(name = FIND_ALL, 
            query = "SELECT cp FROM CompteAphp cp ORDER BY cp.title DESC"),
    @NamedQuery(name = "FIND_ALL_CRITERE", 
            query = "SELECT c FROM Country c WHERE c.username = :username AND c.password = :password"),
})*/

public class CompteAphp {
    
     public static final String FIND_ALL = "CompteAphp.findAll";

  ////////////////////////////////////////////////
  ////////         Attributs           //////////
  //////////////////////////////////////////////

  @Id
  @GeneratedValue
  private Long id;
  @NotNull
  @Column(nullable = false)
  private String username;
  private String password;
  private Long langue;

  ////////////////////////////////////////////////
  ////////         constructeurs       //////////
  //////////////////////////////////////////////
  
    public CompteAphp(String username, String password, Long langue) {
        this.username = username;
        this.password = password;
        this.langue = langue;
    }
    
    public CompteAphp(String username, String password) {
        this.username = username;
        this.password = password;
        this.langue = 1L;
    }
    
    public CompteAphp() {
        this.username = "";
        this.password = "";
        this.langue = 1L;
    }

  ////////////////////////////////////////////////
  ////////         Méthodes            //////////
  //////////////////////////////////////////////
    
    public static String getFIND_ALL() {
        return FIND_ALL;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getLangue() {
        return langue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLangue(Long langue) {
        this.langue = langue;
    }


@Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("eling.compteAphp");
    sb.append("{id=").append(id);
    sb.append(", username='").append(username).append('\'');
    sb.append(", password='").append(password).append('\'');
     sb.append(", password='").append(langue);
    return sb.toString();
  }


    
}
