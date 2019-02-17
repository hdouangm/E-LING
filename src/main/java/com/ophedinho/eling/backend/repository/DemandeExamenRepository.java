/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.repository;

import com.ophedinho.eling.backend.demandeExamen.domain.DemandeExamen;
import static com.ophedinho.eling.backend.demandeExamen.domain.DemandeExamen.FIND_ALL;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ophedinho
 */

@Stateless
public class DemandeExamenRepository {
    
    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<DemandeExamen> list() {
        return em.createNamedQuery(FIND_ALL, DemandeExamen.class).getResultList();
    }

    public DemandeExamen find(Long id) {
        return em.find(DemandeExamen.class, id);
    }
    
    public Long save(DemandeExamen d_examen) {
        em.persist(d_examen);
        return d_examen.getId();
    }
    
    public Long update(Long id, DemandeExamen dExamen){
        DemandeExamen d_examen_new = new DemandeExamen(id,dExamen.getId_dmp(), dExamen.getType(), 
                dExamen.isPublication());
        this.delete(id);
        return this.save(d_examen_new);
    }
    
    public void delete(Long d_examen){
        em.remove(d_examen);
    }
}
