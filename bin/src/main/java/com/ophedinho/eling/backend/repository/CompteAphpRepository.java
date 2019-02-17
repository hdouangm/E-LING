/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.repository;

import com.ophedinho.eling.backend.domain.CompteAphp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ophedinho
 */


@Stateless
public class CompteAphpRepository {
    
    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<CompteAphp> list() {
        return em.createNamedQuery(CompteAphp.FIND_ALL, CompteAphp.class).getResultList();
    }

    public List<CompteAphp> find(CompteAphp cp) {
        String qr = "SELECT c FROM CompteAphp c WHERE c.username = '"+ cp.getUsername() 
                +"' AND c.password = '"+ cp.getPassword()+"'";
        Query query = em.createQuery(qr);
        return query.getResultList();
    }
    
    public Long save(CompteAphp cp) {
        em.persist(cp);
        return cp.getId();
    }
    
}
