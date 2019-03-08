/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.domain;

import static application.domain.NoeudHopital.FIND_ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;



@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM NoeudHopital b ORDER BY b.id DESC")
public class NoeudHopital {
    public static final String FIND_ALL = "NoeudHopital.findAllNoeudHopitals";
    @Id
    @GeneratedValue
    private Integer id;

    public NoeudHopital(){

    }

    public NoeudHopital(Integer id) {
        this.id = id;
    }
    
    

    public Integer getId(){
        return id;
    }

    @Override
    public String toString() {
        return "NoeudHopital{" +
                "id=" + id +
                '}';
    }
}