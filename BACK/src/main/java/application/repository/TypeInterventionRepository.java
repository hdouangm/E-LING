/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repository;

import application.eling.domain.TypeIntervention;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ophedinho
 */

@Stateless
public class TypeInterventionRepository {
    
    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<TypeIntervention> list() {
        return em.createNamedQuery(TypeIntervention.FIND_ALL, TypeIntervention.class).getResultList();
    }
    public Long save(TypeIntervention ti) {
        em.persist(ti);
        return ti.getId();
    }
    
}
