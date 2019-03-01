/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.repository;

import com.ophedinho.eling.backend.domain.TypeExamen;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ophedinho
 */

@Stateless
public class TypeExamenRepository {
    
    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<TypeExamen> list() {
        return em.createNamedQuery(TypeExamen.FIND_ALL, TypeExamen.class).getResultList();
    }
    public Long save(TypeExamen te) {
        em.persist(te);
        return te.getId();
    }
    
}
